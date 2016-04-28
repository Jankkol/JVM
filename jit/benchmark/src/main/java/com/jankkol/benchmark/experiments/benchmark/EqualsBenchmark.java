package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.EqualsParameters;

/**
 * Created by jan on 28.04.16.
 */
public class EqualsBenchmark implements Benchmark {

    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        EqualsParameters equalsParameters = (EqualsParameters) benchmarkParameters;
        int counter = 0;
        for (int i = 0; i < iteration; i++) {
            if ("test".equals(equalsParameters.getStringToEqual())) {
                counter++;
            }
        }
    }


}
