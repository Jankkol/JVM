package com.jankkol.benchmark.experiments.benchmark;

/**
 * Created by jan on 11.05.16.
 */
public class ReflectionExperimentInstance {

    public String name;

    public ReflectionExperimentInstance() {
    }

    public ReflectionExperimentInstance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
