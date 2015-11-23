package com.jankkol.jni.experiments;

/**
 * Created by jan on 23.11.15.
 */
public class JavaArraySortImpl implements ArraySort {

    @Override
    public void sort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
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

}
