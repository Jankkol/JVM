package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.QuickSortParameters;

import java.util.Random;

/**
 * Created by jan on 28.04.16.
 */
public class QuickSortBenchmark implements Benchmark {

    public static int ARRAY_SIZE = 10;

    private static int MAX_RAND = 1000;

    private static int[] ARRAY_TO_SORT;

    private static Random rand = new Random();

    public int[] sort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private void quickSort(int[] arrayToSort, int left, int right) {
        int index = partition(arrayToSort, left, right);
        if (left < index - 1)
            quickSort(arrayToSort, left, index - 1);
        if (index < right)
            quickSort(arrayToSort, index, right);
    }

    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    private static int[] generateRandomIntegerArray() {
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand.nextInt(MAX_RAND) + 1; // rand number from 1 to MAX_RAND
        }
        return array;
    }

    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        QuickSortParameters quickSortParameters = (QuickSortParameters) benchmarkParameters;
        ARRAY_SIZE = quickSortParameters.getArraySize();
        MAX_RAND = quickSortParameters.getMaxRand();
        for (int i = 0; i < iteration; i++) {
            ARRAY_TO_SORT = generateRandomIntegerArray();
            sort(ARRAY_TO_SORT);
        }
    }
}
