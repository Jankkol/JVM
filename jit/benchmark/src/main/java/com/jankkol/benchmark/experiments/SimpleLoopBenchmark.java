package com.jankkol.benchmark.experiments;

import com.jankkol.benchmark.Benchmark;

import java.math.BigDecimal;

/**
 * Created by jan on 25.04.16.
 */
public class SimpleLoopBenchmark implements Benchmark {

    private BigDecimal result;

    public void run(long iteration) {
        result = new BigDecimal(0);
        for (int i = 0; i < iteration; i++) {
            result.add(BigDecimal.ONE);
        }
    }
}
