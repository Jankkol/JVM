package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.ReflectionParameters;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by jan on 05.05.16.
 */
public class ReflectionBenchmark implements Benchmark {


    @Override
    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        ReflectionParameters reflectionBenchmark = (ReflectionParameters) benchmarkParameters;
        switch (reflectionBenchmark.getReflectionBase()) {
            case InvokeMethod:
                invokeMethodBenchmark(iteration, reflectionBenchmark);
            case GetConstructor:
                getConstructorBenchmark(iteration, reflectionBenchmark);
            case AllocateArray:
                allocateArrayBenchmark(iteration, reflectionBenchmark);
            case ChangeField:
                changeFieldBenchmark(iteration, reflectionBenchmark);
        }

    }

    private void changeFieldBenchmark(long iteration, ReflectionParameters reflectionBenchmark) {
        ReflectionExperimentInstance result = new ReflectionExperimentInstance("testInstance");
        if (reflectionBenchmark.isUseReflection() && reflectionBenchmark.isDeclaredMethod()) {
            Field field = null;
            try {
                field = ReflectionExperimentInstance.class.getDeclaredField("name");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < iteration; i++) {
                try {
                    field.set(result, "test");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else if (reflectionBenchmark.isUseReflection()) {
            Field field = null;
            try {
                field = ReflectionExperimentInstance.class.getField("name");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < iteration; i++) {
                try {
                    field.set(result, "test");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 0; i < iteration; i++) {
                result.setName("test");
            }
        }
    }

    private void allocateArrayBenchmark(long iteration, ReflectionParameters reflectionBenchmark) {
        if (reflectionBenchmark.isUseReflection()) {
            for (int i = 0; i < iteration; i++) {
                String[] array = (String[]) Array.newInstance(String.class, 1000);
            }
        } else {
            for (int i = 0; i < iteration; i++) {
                String[] array = new String[1000];
            }
        }

    }

    private void getConstructorBenchmark(long iteration, ReflectionParameters reflectionBenchmark) {
        if (reflectionBenchmark.isUseReflection() && reflectionBenchmark.isDeclaredMethod()) {
            Constructor constructor = null;
            try {
                constructor = ReflectionExperimentInstance.class.getDeclaredConstructor(String.class);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < iteration; i++) {
                try {
                    ReflectionExperimentInstance result = (ReflectionExperimentInstance) constructor.newInstance("testInstance");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } else if (reflectionBenchmark.isUseReflection()) {
            Constructor constructor = null;
            try {
                constructor = ReflectionExperimentInstance.class.getConstructor(String.class);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < iteration; i++) {
                try {
                    ReflectionExperimentInstance result = (ReflectionExperimentInstance) constructor.newInstance("testInstance");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 0; i < iteration; i++) {
                ReflectionExperimentInstance result = new ReflectionExperimentInstance("testInstance");
            }
        }
    }

    private void invokeMethodBenchmark(long iteration, ReflectionParameters reflectionBenchmark) {
        ReflectionExperimentInstance instance = new ReflectionExperimentInstance("testInstance");
        if (reflectionBenchmark.isUseReflection() && reflectionBenchmark.isDeclaredMethod()) {
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
        } else if (reflectionBenchmark.isUseReflection()) {
            Method method = null;
            try {
                method = instance.getClass().getMethod("getName", null);
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
}
