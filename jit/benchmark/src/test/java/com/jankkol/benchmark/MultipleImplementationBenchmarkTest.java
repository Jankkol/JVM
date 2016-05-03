package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.MultipleImplementationBenchmark;
import com.jankkol.benchmark.experiments.benchmark.QuickSortBenchmark;
import com.jankkol.benchmark.experiments.parameters.MultipleImplementationParameters;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jan on 02.05.16.
 */
public class MultipleImplementationBenchmarkTest {

    private static BenchmarkFactory benchmarkFactory;

    private static MultipleImplementationParameters benchmarkParameters;

    private final static long BENCHMARK_ITERATION = 100000L;

    private final static boolean AVOID_WARM_UP = true;

    private final static String URL = "results/MultipleImplementationBenchmark";

    private static StringBuilder stringBuilder;

    @Before
    public void setup() {
        benchmarkParameters = new MultipleImplementationParameters();
        benchmarkParameters.setAvoidWarmUp(AVOID_WARM_UP);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        stringBuilder = new StringBuilder();
    }

    @Test
    public void testMultipleImplementation() {
        benchmarkParameters.setUseInterface(true);
        int[] arrayToSort = QuickSortBenchmark.generateRandomIntegerArray(100, 1000);
        benchmarkParameters.setArrayToSort(arrayToSort);

        for (int i = 0; i < 10; i++) {
            benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
            stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
            benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
            benchmarkFactory.start();
            stringBuilder.append(benchmarkFactory.printFormattedResult());
        }


        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());


        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.NO_SORT);
        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());

        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.JAVA_SORT);
        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());

        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.JAVA_SORT);
        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());

        for (int i = 0; i < 2; i++) {
            benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);
            stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
            benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
            benchmarkFactory.start();
            stringBuilder.append(benchmarkFactory.printFormattedResult());
        }
        WriteResultUtil.writeResult(URL + "/multipleInterfaceImplementation", this.getClass().getSimpleName(), stringBuilder.toString());
    }

    @Test
    public void testAbstractCall() {
        int[] arrayToSort = QuickSortBenchmark.generateRandomIntegerArray(100, 1000);
        benchmarkParameters.setArrayToSort(arrayToSort);
        benchmarkParameters.setAvoidWarmUp(false);
        benchmarkParameters.setWarmUpIteration(benchmarkParameters.getBenchmarkIterationCount());
        benchmarkParameters.setUseInterface(false);
        benchmarkParameters.setRepeatBenchmark(10);
        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);

        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());
        WriteResultUtil.writeResult(URL + "/abstractCall", this.getClass().getSimpleName(), stringBuilder.toString());
    }

    @Test
    public void testInterfaceCall() {
        int[] arrayToSort = QuickSortBenchmark.generateRandomIntegerArray(100, 1000);
        benchmarkParameters.setArrayToSort(arrayToSort);
        benchmarkParameters.setAvoidWarmUp(false);
        benchmarkParameters.setRepeatBenchmark(10);
        benchmarkParameters.setWarmUpIteration(benchmarkParameters.getBenchmarkIterationCount());
        benchmarkParameters.setUseInterface(true);
        benchmarkParameters.setSortImplementation(MultipleImplementationBenchmark.SortImplementation.QUICK_SORT);

        stringBuilder.append(String.format("*************************%s*************************", benchmarkParameters.getSortImplementation()));
        benchmarkFactory = new BenchmarkFactory(new MultipleImplementationBenchmark(), benchmarkParameters);
        benchmarkFactory.start();
        stringBuilder.append(benchmarkFactory.printFormattedResult());
        WriteResultUtil.writeResult(URL + "/interfaceCall", this.getClass().getSimpleName(), stringBuilder.toString());
    }
}
