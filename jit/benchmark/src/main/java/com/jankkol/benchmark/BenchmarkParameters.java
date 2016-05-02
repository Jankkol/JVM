package com.jankkol.benchmark;

/**
 * Created by jan on 25.04.16.
 */
public class BenchmarkParameters {

    /**
     * Number of warm up iteration
     */
    private long warmUpIteration;

    /**
     * Number of benchmark iteration in main loop
     */
    private long benchmarkIterationCount;

    /**
     * Number of benchmark iteration to be repeated
     */
    private int repeatBenchmark;

    /**
     * If is true, warm up is not trigger. Used in MultipleImplementationBenchmark.
     */
    private boolean avoidWarmUp;

    public long getWarmUpIteration() {
        return warmUpIteration;
    }

    public void setWarmUpIteration(long warmUpIteration) {
        this.warmUpIteration = warmUpIteration;
    }

    public long getBenchmarkIterationCount() {
        return benchmarkIterationCount;
    }

    public void setBenchmarkIterationCount(long benchmarkIterationCount) {
        this.benchmarkIterationCount = benchmarkIterationCount;
    }

    public int getRepeatBenchmark() {
        return repeatBenchmark;
    }

    public void setRepeatBenchmark(int repeatBenchmark) {
        this.repeatBenchmark = repeatBenchmark;
    }

    public boolean isAvoidWarmUp() {
        return avoidWarmUp;
    }

    public void setAvoidWarmUp(boolean avoidWarmUp) {
        this.avoidWarmUp = avoidWarmUp;
    }
}
