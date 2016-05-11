package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 05.05.16.
 */
public class ReflectionParameters extends BenchmarkParameters {

    private boolean useReflection;

    private ReflectionBase reflectionBase;

    private boolean declaredMethod;

    public boolean isUseReflection() {
        return useReflection;
    }

    public void setUseReflection(boolean useReflection) {
        this.useReflection = useReflection;
    }

    public ReflectionBase getReflectionBase() {
        return reflectionBase;
    }

    public void setReflectionBase(ReflectionBase reflectionBase) {
        this.reflectionBase = reflectionBase;
    }

    public boolean isDeclaredMethod() {
        return declaredMethod;
    }

    public void setDeclaredMethod(boolean declaredMethod) {
        this.declaredMethod = declaredMethod;
    }

    public enum ReflectionBase {
        InvokeMethod, GetConstructor, AllocateArray, ChangeField
    }
}

