package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.DeadCodeBenchmark;
import com.jankkol.benchmark.experiments.benchmark.QuickSortBenchmark;
import com.jankkol.benchmark.experiments.parameters.QuickSortParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 28.04.16.
 */
public class DeadCodeBenchmarkTest {
    private static BenchmarkFactory benchmarkFactory;

    private final static BenchmarkParameters benchmarkParameters = new BenchmarkParameters();

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 1000000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static String URL = "results/DeadCodeBenchmark";

    @BeforeClass
    public static void setup() {
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
    }

    @Test
    public void deadCodeBenchmark() {
        benchmarkFactory = new BenchmarkFactory(new DeadCodeBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/client", this.getClass().getSimpleName(), result);
    }
}
