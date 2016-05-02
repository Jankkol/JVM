package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.UnboxingParameters;

/**
 * Created by jan on 02.05.16.
 */
public class UnboxingBenchmark implements Benchmark {


    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        UnboxingParameters unboxingParameters = (UnboxingParameters) benchmarkParameters;
        boolean usePrimitives = unboxingParameters.isUsePrimitives();
        int modulo = unboxingParameters.getModulo();
        if (usePrimitives) {
            for (int i = 0; i < iteration; i++) {
                if (i % modulo == 0) {
                    System.out.println("Unboxing primitives benchmark");
                }
            }
        } else {
            for (Integer i = 0; i < iteration; i++) {
                if (i % modulo == 0) {
                    System.out.println("Unboxing object benchmark");
                }
            }
        }
    }
}
