package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.SimpleLoopBenchmark;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jan on 25.04.16.
 */
public class SimpleLoopBenchmarkTest {

    private static BenchmarkFactory benchmarkFactory;

    private final static long WARM_UP_ITERATION = 1000000L;

    private final static long BENCHMARK_ITERATION = 10000000L;

    private final static int REPEAT_ITERATION_TIME = 10;

    private final static String URL = "results/SimpleLoopBenchmark";

    @BeforeClass
    public static void setup() {
        BenchmarkParameters benchmarkParameters = new BenchmarkParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkFactory = new BenchmarkFactory(new SimpleLoopBenchmark(), benchmarkParameters);
    }

    @Test
    public void testSimpleLoop() throws IOException {
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL, this.getClass().getSimpleName(), result);
    }


}
