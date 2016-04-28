package com.jankkol.benchmark.experiments.parameters;

import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 28.04.16.
 */
public class EqualsParameters extends BenchmarkParameters {

    private String stringToEqual;

    public String getStringToEqual() {
        return stringToEqual;
    }

    public void setStringToEqual(String stringToEqual) {
        this.stringToEqual = stringToEqual;
    }
}
