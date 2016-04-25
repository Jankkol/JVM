package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.SimpleLoopBenchmark;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 25.04.16.
 */
public class SimpleLoopBenchmarkTest {

    private static BenchmarkFactory benchmarkFactory;

    private final static long WARM_UP_ITERATION = 1000000L;

    private final static long BENCHMARK_ITERATION = 1000000L;

    @BeforeClass
    public static void setup() {
        BenchmarkParameters benchmarkParameters = new BenchmarkParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkFactory = new BenchmarkFactory(new SimpleLoopBenchmark(), benchmarkParameters);
    }

    @Test
    public void testSimpleLoop() {
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();
    }

}
