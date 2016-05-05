package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 05.05.16.
 */
public class ReflectionParameters extends BenchmarkParameters {

    private boolean useReflection;

    public boolean isUseReflection() {
        return useReflection;
    }

    public void setUseReflection(boolean useReflection) {
        this.useReflection = useReflection;
    }
}
