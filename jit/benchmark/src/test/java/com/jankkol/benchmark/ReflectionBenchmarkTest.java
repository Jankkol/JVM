package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.ReflectionBenchmark;
import com.jankkol.benchmark.experiments.parameters.ReflectionParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 28.04.16.
 */
public class ReflectionBenchmarkTest {
    private static BenchmarkFactory benchmarkFactory;

    private static ReflectionParameters benchmarkParameters;

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 100000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static String URL = "results/ReflectionBenchmarkTest";

    @BeforeClass
    public static void setup() {
        benchmarkParameters = new ReflectionParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkFactory = new BenchmarkFactory(new ReflectionBenchmark(), benchmarkParameters);
    }

    @Test
    public void reflectionCallTest() {
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/reflectionCall", this.getClass().getSimpleName(), result);
    }

    @Test
    public void methodCallTest() {
        benchmarkParameters.setUseReflection(false);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/methodCall", this.getClass().getSimpleName(), result);
    }

}
