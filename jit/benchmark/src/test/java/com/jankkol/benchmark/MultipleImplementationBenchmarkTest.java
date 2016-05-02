package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.MultipleImplementationBenchmark;
import com.jankkol.benchmark.experiments.benchmark.QuickSortBenchmark;
import com.jankkol.benchmark.experiments.parameters.MultipleImplementationParameters;
import org.junit.Test;

/**
 * Created by jan on 02.05.16.
 */
public class MultipleImplementationBenchmarkTest {

    private static BenchmarkFactory benchmarkFactory;

    private final static long BENCHMARK_ITERATION = 1000000L;

    private final static boolean AVOID_WARM_UP = true;

    private final static boolean USE_INTERFACE = false;

    @Test
    public void testMultipleImplementation() {

        MultipleImplementationParameters benchmarkParameters = new MultipleImplementationParameters();
        benchmarkParameters.setAvoidWarmUp(AVOID_WARM_UP);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setUseInterface(USE_INTERFACE);
        int[] arrayToSort = QuickSortBenchmark.generateRandomIntegerArray(100, 1000);
        benchmarkParameters.setArrayToSort(arrayToSort);

        for (int i = 0; i < 10; i++) {
            benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
            System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
            benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
            benchmarkFactory.start();
            benchmarkFactory.printFormattedResult();
        }


        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
        System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();


        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.NO_SORT);
        System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();

        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.JAVA_SORT);
        System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();

        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.JAVA_SORT);
        System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        benchmarkFactory.printFormattedResult();

        for (int i = 0; i < 2; i++) {
            benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
            System.out.println(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
            benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
            benchmarkFactory.start();
            benchmarkFactory.printFormattedResult();
        }
    }
}
