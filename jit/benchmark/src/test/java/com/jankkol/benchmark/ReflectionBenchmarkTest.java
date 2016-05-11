package com.jankkol.benchmark;

import com.jankkol.benchmark.experiments.benchmark.ReflectionBenchmark;
import com.jankkol.benchmark.experiments.parameters.ReflectionParameters;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by jan on 28.04.16.
 */
public class ReflectionBenchmarkTest {
    private static BenchmarkFactory benchmarkFactory;

    private static ReflectionParameters benchmarkParameters;

    private final static long WARM_UP_ITERATION = 100000L;

    private final static long BENCHMARK_ITERATION = 100000L;

    private final static int REPEAT_ITERATION_TIME = 5;

    private final static String URL = "results/ReflectionBenchmarkTest";

    @BeforeClass
    public static void setup() {
        benchmarkParameters = new ReflectionParameters();
        benchmarkParameters.setWarmUpIteration(WARM_UP_ITERATION);
        benchmarkParameters.setBenchmarkIterationCount(BENCHMARK_ITERATION);
        benchmarkParameters.setRepeatBenchmark(REPEAT_ITERATION_TIME);
        benchmarkFactory = new BenchmarkFactory(new ReflectionBenchmark(), benchmarkParameters);
    }

    @Test
    public void declaredReflectionCallTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.InvokeMethod);
        benchmarkParameters.setDeclaredMethod(true);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/methodCall/declaredReflectionCall", this.getClass().getSimpleName(), result);
    }

    @Test
    public void reflectionCallTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.InvokeMethod);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/methodCall/reflectionCall", this.getClass().getSimpleName(), result);
    }

    @Test
    public void methodCallTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.InvokeMethod);
        benchmarkParameters.setUseReflection(false);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/methodCall/staticCall", this.getClass().getSimpleName(), result);
    }


    @Test
    public void declaredConstructorTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.GetConstructor);
        benchmarkParameters.setDeclaredMethod(true);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/constructor/declaredConstructor", this.getClass().getSimpleName(), result);
    }

    @Test
    public void reflectionConstructorTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.GetConstructor);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/constructor/reflectionConstructor", this.getClass().getSimpleName(), result);
    }

    @Test
    public void staticConstructorTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.GetConstructor);
        benchmarkParameters.setUseReflection(false);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/constructor/staticConstructor", this.getClass().getSimpleName(), result);
    }

    @Test
    public void staticFieldTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.ChangeField);
        benchmarkParameters.setUseReflection(false);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/field/staticField", this.getClass().getSimpleName(), result);
    }

    @Test
    public void reflectionFieldTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.ChangeField);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/field/reflectionField", this.getClass().getSimpleName(), result);
    }

    @Test
    public void declaredFieldTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.ChangeField);
        benchmarkParameters.setUseReflection(true);
        benchmarkParameters.setDeclaredMethod(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/field/declaredField", this.getClass().getSimpleName(), result);
    }

    @Test
    public void allocateArrayTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.AllocateArray);
        benchmarkParameters.setUseReflection(false);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/array/allocateArray", this.getClass().getSimpleName(), result);
    }

    @Test
    public void allocateArrayReflectionTest() {
        benchmarkParameters.setReflectionBase(ReflectionParameters.ReflectionBase.AllocateArray);
        benchmarkParameters.setUseReflection(true);
        benchmarkFactory.start();
        String result = benchmarkFactory.printFormattedResult();
        WriteResultUtil.writeResult(URL + "/array/allocateArrayReflection", this.getClass().getSimpleName(), result);
    }

}
