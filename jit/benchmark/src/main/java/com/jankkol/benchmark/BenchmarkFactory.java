package com.jankkol.benchmark;

/**
 * Created by jan on 25.04.16.
 */
public class BenchmarkFactory {

    private Benchmark benchmark;

    private BenchmarkParameters benchmarkParameters;

    private boolean isRepeatedBenchmark;

    private long benchmarkTime;

    private long warmUpTime;

    private long duration;

    private long[] benchmarkTimesArray;

    private static final long TO_MILIS = 1000000L;

    public BenchmarkFactory(Benchmark benchmark, BenchmarkParameters benchmarkParameters) {
        this.benchmark = benchmark;
        this.benchmarkParameters = benchmarkParameters;
        this.isRepeatedBenchmark = benchmarkParameters.getRepeatBenchmark() > 0;
        if (isRepeatedBenchmark) {
            this.benchmarkTimesArray = new long[benchmarkParameters.getRepeatBenchmark()];
        }
    }

    public void start() {
        long start = System.nanoTime();

        if (!benchmarkParameters.isAvoidWarmUp()) {
            long startWarmUp = System.nanoTime();
            benchmark.run(benchmarkParameters.getWarmUpIteration(), benchmarkParameters);
            long stopWarmUp = System.nanoTime();
            warmUpTime = stopWarmUp - startWarmUp;
        }

        if (!isRepeatedBenchmark) {
            singleBenchmark();
        } else {
            repeatedBenchmark();
        }
        long stop = System.nanoTime();
        this.duration = stop - start;
    }

    private void singleBenchmark() {
        long startBenchmark = System.nanoTime();
        benchmark.run(benchmarkParameters.getBenchmarkIterationCount(), benchmarkParameters);
        long stopBenchmark = System.nanoTime();
        benchmarkTime = stopBenchmark - startBenchmark;
    }

    private void repeatedBenchmark() {
        for (int i = 0; i < benchmarkParameters.getRepeatBenchmark(); i++) {
            long startBenchmark = System.nanoTime();
            benchmark.run(benchmarkParameters.getBenchmarkIterationCount(), benchmarkParameters);
            long stopBenchmark = System.nanoTime();
            benchmarkTimesArray[i] = stopBenchmark - startBenchmark;
        }
    }

    public String printFormattedResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!benchmarkParameters.isAvoidWarmUp()) {
            stringBuilder.append("--------------------------- WARM UP ---------------------------").append("\n");
            stringBuilder.append("Warm up time : ").append(warmUpTime / TO_MILIS).append("ms\n");
            stringBuilder.append("Warm up iteration time : ").append(averageTime(warmUpTime, benchmarkParameters.getWarmUpIteration())).append(" nano seconds\n");
            stringBuilder.append("Warm up iteration per ms: ").append(iterationPerMs(warmUpTime, benchmarkParameters.getWarmUpIteration())).append("\n");
        }
        stringBuilder.append("--------------------------- BENCHMARK ---------------------------").append("\n");
        if (!isRepeatedBenchmark) {
            stringBuilder.append("Benchmark time : ").append(benchmarkTime / TO_MILIS).append("ms\n");
            stringBuilder.append("Benchmark iteration time : ").append(averageTime(benchmarkTime, benchmarkParameters.getBenchmarkIterationCount())).append(" nano seconds\n");
            stringBuilder.append("Benchmark iteration per ms: ").append(iterationPerMs(benchmarkTime, benchmarkParameters.getBenchmarkIterationCount())).append("\n");
        } else {
            for (int i = 0; i < benchmarkTimesArray.length; i++) {
                stringBuilder.append("Stage : ").append(i).append("\n");
                stringBuilder.append("Benchmark time : ").append(benchmarkTimesArray[i] / TO_MILIS).append("ms\n");
                stringBuilder.append("Benchmark iteration time : ").append(averageTime(benchmarkTimesArray[i], benchmarkParameters.getBenchmarkIterationCount())).append(" nano seconds\n");
                stringBuilder.append("Benchmark iteration per ms: ").append(iterationPerMs(benchmarkTimesArray[i], benchmarkParameters.getBenchmarkIterationCount())).append("\n");
            }
        }

        stringBuilder.append("--------------------------- OVERALL ---------------------------").append("\n");
        stringBuilder.append("Warm up iteration performed : ").append(benchmarkParameters.getWarmUpIteration()).append("\n");
        stringBuilder.append("Benchmark iteration count : ").append(benchmarkParameters.getBenchmarkIterationCount()).append("\n");
        stringBuilder.append("Benchmark overall time : ").append(duration / TO_MILIS).append("ms\n");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private long iterationPerMs(long benchmarkTime, long benchmarkIterationCount) {
        return benchmarkIterationCount / (benchmarkTime / TO_MILIS);
    }

    public long averageTime(long time, long iteration) {
        return (time / iteration);
    }
}
