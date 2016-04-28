package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 28.04.16.
 */
public class QuickSortParameters extends BenchmarkParameters {

    private int arraySize;

    private int maxRand;

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int getMaxRand() {
        return maxRand;
    }

    public void setMaxRand(int maxRand) {
        this.maxRand = maxRand;
    }
}
