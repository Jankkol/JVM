package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 02.05.16.
 */
public class UnboxingParameters extends BenchmarkParameters {

    private boolean usePrimitives;

    private int modulo;

    public boolean isUsePrimitives() {
        return usePrimitives;
    }

    public void setUsePrimitives(boolean usePrimitives) {
        this.usePrimitives = usePrimitives;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }
}
