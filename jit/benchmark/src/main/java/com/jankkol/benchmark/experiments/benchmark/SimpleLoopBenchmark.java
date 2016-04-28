package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;

import java.math.BigDecimal;

/**
 * Created by jan on 25.04.16.
 */
public class SimpleLoopBenchmark implements Benchmark {

    private BigDecimal result;

    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        result = new BigDecimal(0);
        for (int i = 0; i < iteration; i++) {
            result.add(BigDecimal.ONE);
        }
    }
}
