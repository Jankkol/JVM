package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.UnboxingBenchmark;
import com.jankkol.benchmark.experiments.parameters.UnboxingParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 02.05.16.
 */
public class UnboxingBenchmarkTest {

    private static BenchmarkFactory benchmarkFactory;

    private final static long WARM_UP_ITERATION = 1000000L;

    private final static long BENCHMARK_ITERATION = 10000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static boolean USE_PRIMITIVES = true;

    private final static int MODULO = 1000000;

    @BeforeClass
    public static void setup() {
        UnboxingParameters benchmarkParameters = new UnboxingParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setUsePrimitives(USE_PRIMITIVES);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkParameters.setModulo(MODULO);
        benchmarkFactory = new BenchmarkFactory(new UnboxingBenchmark(), benchmarkParameters);
    }

    @Test
    public void testUnboxing() {
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();
    }


}
