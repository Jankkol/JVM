package com.jankkol.jni.experiments;

/**
 * Created by jan on 23.11.15.
 */
public class NativeCArraySortImpl implements ArraySort {

    native int[] sortArray(int[] arrayToSort);

    static {
        System.loadLibrary("sortarray");
    }

    @Override
    public int[] sort(int[] arrayToSort) {
        return sortArray(arrayToSort);
    }
}
