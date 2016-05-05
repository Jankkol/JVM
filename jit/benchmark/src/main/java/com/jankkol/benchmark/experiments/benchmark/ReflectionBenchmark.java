package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.ReflectionParameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jan on 05.05.16.
 */
public class ReflectionBenchmark implements Benchmark {


    @Override
    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        ReflectionParameters reflectionBenchmark = (ReflectionParameters) benchmarkParameters;
        ReflectionExperimentInstance instance = new ReflectionExperimentInstance("testInstance");
        if (reflectionBenchmark.isUseReflection()) {
            Method method = null;
            try {
                method = instance.getClass().getDeclaredMethod("getName", null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < iteration; i++) {
                try {
                    String result = (String) method.invoke(instance, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 0; i < iteration; i++) {
                String result = instance.getName();
            }
        }


    }

    private class ReflectionExperimentInstance {

        private String name;

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
}
