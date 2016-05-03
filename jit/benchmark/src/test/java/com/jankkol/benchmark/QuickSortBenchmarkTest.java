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

    private final static QuickSortParameters benchmarkParameters = new QuickSortParameters();

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 100000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static int MAX_RAND = 100;

    private final static String URL = "results/QuickSortBenchmark";

    @BeforeClass
    public static void setup() {
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkParameters.setMaxRand(MAX_RAND);
    }

    @Test
    public void quickSortSmallArrayBenchmark() {
        benchmarkParameters.setArraySize(100);
        benchmarkFactory = new BenchmarkFactory(new QuickSortBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/smallArray", this.getClass().getSimpleName(), result);
    }

    @Test
    public void quickSortBigArrayBenchmark() {
        benchmarkParameters.setArraySize(1000);
        benchmarkFactory = new BenchmarkFactory(new QuickSortBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/bigArray", this.getClass().getSimpleName(), result);
    }
}
