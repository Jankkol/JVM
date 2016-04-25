package com.jankkol.benchmark;

/**
 * Created by jan on 25.04.16.
 */
public class BenchmarkFactory {

    private Benchmark benchmark;

    private BenchmarkParameters benchmarkParameters;

    private long benchmarkTime;

    private long warmUpTime;

    private long duration;

    private static final long TO_MILIS = 1000000L;

    public BenchmarkFactory(Benchmark benchmark, BenchmarkParameters benchmarkParameters) {
        this.benchmark = benchmark;
        this.benchmarkParameters = benchmarkParameters;
    }

    public void start() {
        long start = System.nanoTime();

        long startWarmUp = System.nanoTime();
        benchmark.run(benchmarkParameters.getWarmUpIteration());
        long stopWarmUp = System.nanoTime();

        long startBenchmark = System.nanoTime();
        benchmark.run(benchmarkParameters.getBenchmarkIterationCount());
        long stopBenchmark = System.nanoTime();

        benchmarkTime = stopBenchmark - startBenchmark;
        warmUpTime = stopWarmUp - startWarmUp;
        long stop = System.nanoTime();
        this.duration = stop - start;
    }

    public void printFormattedResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------------------------- WARM UP ---------------------------").append("\n");
        stringBuilder.append("Warm up time : ").append(warmUpTime / TO_MILIS).append("ms\n");
        stringBuilder.append("Warm up iteration time : ").append(averageTime(warmUpTime, benchmarkParameters.getWarmUpIteration())).append(" nano seconds\n");

        stringBuilder.append("--------------------------- BENCHMARK ---------------------------").append("\n");
        stringBuilder.append("Benchmark time : ").append(benchmarkTime / TO_MILIS).append("ms\n");
        stringBuilder.append("Benchmark iteration time : ").append(averageTime(benchmarkTime, benchmarkParameters.getBenchmarkIterationCount())).append(" nano seconds\n");


        stringBuilder.append("--------------------------- OVERALL ---------------------------").append("\n");
        stringBuilder.append("Warm up iteration performed : ").append(benchmarkParameters.getWarmUpIteration()).append("\n");
        stringBuilder.append("Iteration performed : ").append(benchmarkParameters.getBenchmarkIterationCount()).append("\n");
        stringBuilder.append("Benchmark overall time : ").append(duration / TO_MILIS).append("ms\n");
        System.out.println(stringBuilder.toString());
    }

    public long averageTime(long time, long iteration) {
        return (time / iteration);
    }
}
