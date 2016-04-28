package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.QuickSortBenchmark;
import com.jankkol.benchmark.experiments.parameters.QuickSortParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 28.04.16.
 */
public class QuickSortBenchmarkTest {
    private static BenchmarkFactory benchmarkFactory;

    private final static long WARM_UP_ITERATION = 1000000L;

    private final static long BENCHMARK_ITERATION = 10000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static int ARRAY_SIZE = 10;

    private final static int MAX_RAND = 100;

    @BeforeClass
    public static void setup() {
        QuickSortParameters benchmarkParameters = new QuickSortParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkParameters.setArraySize(ARRAY_SIZE);
        benchmarkParameters.setMaxRand(MAX_RAND);
        benchmarkFactory = new BenchmarkFactory(new QuickSortBenchmark(), benchmarkParameters);
    }

    @Test
    public void quickSortBenchmark() {
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();
    }
}
