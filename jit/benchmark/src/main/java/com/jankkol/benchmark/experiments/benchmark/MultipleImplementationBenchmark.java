package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.MultipleImplementationParameters;

import java.util.Arrays;

/**
 * Created by jan on 02.05.16.
 */
public class MultipleImplementationBenchmark implements Benchmark {

    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        MultipleImplementationParameters multipleImplementationParameters = (MultipleImplementationParameters) benchmarkParameters;
        ArrayUtilInterface arrayUtilInterface = resolveImplementation(multipleImplementationParameters.getSortImplementation());
        AbstractArrayUtil abstractArrayUtil = resolveAbstractImplementation(multipleImplementationParameters.getSortImplementation());
        for (int i = 0; i < iteration; i++) {
            int[] arrayClone = Arrays.copyOf(multipleImplementationParameters.getArrayToSort(), multipleImplementationParameters.getArrayToSort().length);
            if (multipleImplementationParameters.isUseInterface()) {
                arrayUtilInterface.sumAndSort(arrayClone);
            } else {
                abstractArrayUtil.sumAndSort(arrayClone);
            }
        }
    }

    private AbstractArrayUtil resolveAbstractImplementation(SortImplementation sortImplementation) {
        switch (sortImplementation) {
            case QUICK_SORT:
                return new QuickSortImpl();
            case JAVA_SORT:
                return new JavaSortImpl();
            case NO_SORT:
                return new NoSortImpl();
            default:
                return new NoSortImpl();
        }
    }

    private ArrayUtilInterface resolveImplementation(SortImplementation sortImplementation) {
        switch (sortImplementation) {
            case QUICK_SORT:
                return new QuickSortImpl();
            case JAVA_SORT:
                return new JavaSortImpl();
            case NO_SORT:
                return new NoSortImpl();
            default:
                return new NoSortImpl();
        }
    }

    private class QuickSortImpl extends AbstractArrayUtil implements ArrayUtilInterface {

        public int sumAndSort(int[] collection) {
            QuickSortBenchmark quickSortBenchmark = new QuickSortBenchmark();
            quickSortBenchmark.sort(collection);
            return sumArray(collection);
        }
    }

    private class JavaSortImpl extends AbstractArrayUtil implements ArrayUtilInterface {

        public int sumAndSort(int[] collection) {
            Arrays.sort(collection);
            return sumArray(collection);
        }
    }

    private class NoSortImpl extends AbstractArrayUtil implements ArrayUtilInterface {

        public int sumAndSort(int[] collection) {
            return sumArray(collection);
        }
    }

    public static int sumArray(int[] collection) {
        int result = 0;
        for (int i : collection) {
            result = +i;
        }
        return result;
    }

    public enum SortImplementation {
        QUICK_SORT, JAVA_SORT, NO_SORT
    }

}
