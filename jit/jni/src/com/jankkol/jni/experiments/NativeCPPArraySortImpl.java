package com.jankkol.jni.experiments;

/**
 * Created by jan on 29.11.15.
 */
public class NativeCPPArraySortImpl implements ArraySort {

    native int[] sortArray(int[] arrayToSort);

    static {
        System.loadLibrary("sortarraycpp");
    }

    @Override
    public int[] sort(int[] arrayToSort) {
        return sortArray(arrayToSort);
    }

}
