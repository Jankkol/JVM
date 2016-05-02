package com.jankkol.benchmark.experiments.benchmark;

import com.jankkol.benchmark.Benchmark;
import com.jankkol.benchmark.BenchmarkParameters;
import com.jankkol.benchmark.experiments.parameters.QuickSortParameters;

import java.util.Random;

/**
 * Created by jan on 28.04.16.
 */
public class QuickSortBenchmark implements Benchmark {

    private static Random rand = new Random();

    public int[] sort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    public void quickSort(int[] arrayToSort, int left, int right) {
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

    public static int[] generateRandomIntegerArray(int arraySize, int maxRand) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(maxRand) + 1; // rand number from 1 to MAX_RAND
        }
        return array;
    }

    public void run(long iteration, BenchmarkParameters benchmarkParameters) {
        QuickSortParameters quickSortParameters = (QuickSortParameters) benchmarkParameters;
        int arraySize = quickSortParameters.getArraySize();
        int maxRand = quickSortParameters.getMaxRand();
        for (int i = 0; i < iteration; i++) {
            int[] arrayToSort = generateRandomIntegerArray(arraySize, maxRand);
            sort(arrayToSort);
        }
    }
}
