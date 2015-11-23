package com.jankkol.jni.experiments;

import java.util.Random;

/**
 * Created by jan on 23.11.15.
 */
public class PrimitiveArraySortTest {

    public static int ARRAY_SIZE = 1000000;

    private static int MAX_RAND = 10000;

    private static Random rand = new Random();

    public static void main(String[] args) {
        int[] array = generateRandomInteger();
        ArraySort arraySort = new NativeCArraySortImpl();
        long start = System.currentTimeMillis();
        int[] sortedArray = arraySort.sort(array);
        long end = System.currentTimeMillis();
        for(int i = 0; i < sortedArray.length; i ++){
            System.out.print(sortedArray[i] + ", ");
        }
        System.out.print(end - start);
    }

    private static int[] generateRandomInteger() {
        int[] array = new int[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++ ){
            array[i] = rand.nextInt(MAX_RAND) + 1; // rand number from 1 to MAX_RAND
        }
        return array;
    }
}
