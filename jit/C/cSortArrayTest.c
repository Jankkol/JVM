#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void quickSort(int* arrayToSort, int left, int right) {
   int index = partition(arrayToSort, left, right);
   if (left < index - 1) {
      quickSort(arrayToSort, left, index - 1);
   }  
   if (index < right) {
      quickSort(arrayToSort, index, right);
   }
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

int main(int argc, char** argv) {

    int size = atoi(argv[1]);
    int tab[size];
    int i, j;
    clock_t t1, t2;

    t1 = clock();   

    for (i = 0; i < size; i++) {
      tab[i] = rand() % 10000;
    }
    quickSort(tab, 0, size);
    
    t2 = clock();   
    float diff = (((float)t2 - (float)t1) / 1000000.0F ) * 1000;   
    printf("%f\n",diff);
    return 0;
    
}


