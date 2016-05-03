package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.EqualsInlineBenchmark;
import com.jankkol.benchmark.experiments.parameters.EqualsParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 28.04.16.
 */
public class EqualsInlineBenchmarkTest {
    private static BenchmarkFactory benchmarkFactory;

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 1000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static String STRING_TO_EQUAL = "test";

    private final static String URL = "results/EqualsInlineBenchmark";

    @BeforeClass
    public static void setup() {
        EqualsParameters benchmarkParameters = new EqualsParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkParameters.setStringToEqual(STRING_TO_EQUAL);
        benchmarkFactory = new BenchmarkFactory(new EqualsInlineBenchmark(), benchmarkParameters);
    }

    @Test
    public void equalsInlineTest() {
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/withoutInline", this.getClass().getSimpleName(), result);
    }
}
