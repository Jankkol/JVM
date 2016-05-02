package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.benchmark.MultipleImplementationBenchmark.SortImplementation;

/**
 * Created by jan on 02.05.16.
 */
public class MultipleImplementationParameters extends BenchmarkParameters {

    private SortImplementation sortImplementation;

    private int[] arrayToSort;

    private boolean useInterface;

    public boolean isUseInterface() {
        return useInterface;
    }

    public void setUseInterface(boolean useInterface) {
        this.useInterface = useInterface;
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public SortImplementation getSortImplementation() {
        return sortImplementation;
    }

    public void setSortImplementation(SortImplementation sortImplementation) {
        this.sortImplementation = sortImplementation;
    }
}
