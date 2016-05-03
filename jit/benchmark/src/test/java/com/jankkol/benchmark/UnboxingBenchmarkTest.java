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

    private static UnboxingParameters benchmarkParameters;

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 1000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static int MODULO = 1000000;

    private final static String URL = "results/UnboxingBenchmark";

    @BeforeClass
    public static void setup() {
        benchmarkParameters = new UnboxingParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkParameters.setModulo(MODULO);
    }

    @Test
    public void testUnboxingPrimitives() {
        benchmarkParameters.setUsePrimitives(true);
        benchmarkFactory = new BenchmarkFactory(new UnboxingBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/primitives", this.getClass().getSimpleName(), result);
    }

    @Test
    public void testUnboxingObjects() {
        benchmarkParameters.setUsePrimitives(false);
        benchmarkFactory = new BenchmarkFactory(new UnboxingBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/objects", this.getClass().getSimpleName(), result);
    }


}
