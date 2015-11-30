package com.jankkol.jni.experiments;

import java.util.Random;

/**
 * Created by jan on 23.11.15.
 */
public class PrimitiveArraySortTest {

    public static int ARRAY_SIZE = 1000000;

    private static int MAX_RAND = 10000;

    private static int LOOP_ITERATION = 1;

    private static Random rand = new Random();

    public static void main(String[] args) {

        int[] arrayFirst, arraySecond, arrayThird;
        ArraySort javaArraySort = new JavaArraySortImpl();
        ArraySort cArraySort = new NativeCArraySortImpl();
        ArraySort cppArraySort = new NativeCPPArraySortImpl();

        long javaSortTime = 0;
        long cSortTime = 0;
        long cppSortTime = 0;
        for (int i = 0; i < LOOP_ITERATION; i++) {
            arrayFirst = generateRandomInteger();
            arraySecond = arrayFirst.clone();
            arrayThird = arrayFirst.clone();
            javaSortTime += sortArrayByCustomImpl(javaArraySort, arrayFirst);
            cSortTime += sortArrayByCustomImpl(cArraySort, arraySecond);
            cppSortTime += sortArrayByCustomImpl(cppArraySort, arrayThird);
        }
        System.out.println("Java time: " + javaSortTime);
        System.out.println("C time: " + cSortTime);
        System.out.println("C++ time: " + cppSortTime);
    }

    private static int[] generateRandomInteger() {
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand.nextInt(MAX_RAND) + 1; // rand number from 1 to MAX_RAND
        }
        return array;
    }

    public static long sortArrayByCustomImpl(ArraySort sortImpl, int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < LOOP_ITERATION; i++) {
            sortImpl.sort(array);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
