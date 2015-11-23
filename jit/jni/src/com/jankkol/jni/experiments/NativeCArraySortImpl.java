package com.jankkol.jni.experiments;

/**
 * Created by jan on 23.11.15.
 */
public class NativeCArraySortImpl implements ArraySort {

    native void sortArray(int[] arrayToSort);

    static {
        System.loadLibrary("sortarray");
    }

    @Override
    public void sort(int[] arrayToSort) {
        sortArray(arrayToSort);
    }
}
