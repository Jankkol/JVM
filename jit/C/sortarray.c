#include<stdio.h>
#include<jni.h>
#include "com_jankkol_jni_experiments_NativeCArraySortImpl.h"

void quicksort(jint x[],int first,int last){
    int pivot,j,temp,i;

     if(first<last){
         pivot=first;
         i=first;
         j=last;

         while(i<j){
             while(x[i]<=x[pivot]&&i<last)
                 i++;
             while(x[j]>x[pivot])
                 j--;
             if(i<j){
                 temp=x[i];
                  x[i]=x[j];
                  x[j]=temp;
             }
         }

         temp=x[pivot];
         x[pivot]=x[j];
         x[j]=temp;
         quicksort(x,first,j-1);
         quicksort(x,j+1,last);

    }
}

JNIEXPORT jintArray JNICALL Java_com_jankkol_jni_experiments_NativeCArraySortImpl_sortArray(JNIEnv *env, jobject object, jintArray array) {

    jintArray result;
    jsize len = (*env)->GetArrayLength(env,array);
    result = (*env)->NewIntArray(env, len);
    if (result == NULL) {
        return NULL; /* out of memory error thrown */
    }    

    jint *body = (*env)->GetIntArrayElements(env,array,0);
    quicksort(body, 0, len);

    (*env)->SetIntArrayRegion(env, result, 0, len, body);
    return result;
    
}


