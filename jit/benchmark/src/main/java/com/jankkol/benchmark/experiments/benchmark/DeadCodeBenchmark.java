package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;

/**
 * Created by jan on 11.05.16.
 */
public class DeadCodeBenchmark implements Benchmark {
    @Override
    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        for (int i = 0; i < iteration; i++) {

        }
    }
}
