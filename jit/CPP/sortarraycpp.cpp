#include<stdio.h>
#include<jni.h>
#include "com_jankkol_jni_experiments_NativeCPPArraySortImpl.h"


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

void quickSort(int* arrayToSort, int left, int right) {
   int index = partition(arrayToSort, left, right);
   if (left < index - 1) {
      quickSort(arrayToSort, left, index - 1);
   }  
   if (index < right) {
      quickSort(arrayToSort, index, right);
   }
}
JNIEXPORT jintArray JNICALL Java_com_jankkol_jni_experiments_NativeCPPArraySortImpl_sortArray(JNIEnv *env, jobject object, jintArray array) {

    jintArray result;
    jsize len = env->GetArrayLength(array);
    result = env->NewIntArray(len);
    if (result == NULL) {
        return NULL; /* out of memory error thrown */
    }    

    jint *body = env->GetIntArrayElements(array,0);
    quickSort(body, 0, len);

    env->SetIntArrayRegion(result, 0, len, body);
    return result;
    
}


