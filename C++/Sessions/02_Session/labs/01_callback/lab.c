#include <stdio.h>
#include <stdlib.h>

typedef int* (*CallbackFunc)(int ** arr_2d , int arr_size , int * row_sizes , int (*func)(int * , int));

int sum_array(int *arr, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    return sum;
}

int* process_2d_array(int **arr_2d, int arr_size, int *row_sizes, int (*func)(int *, int)) {
    int *sums = (int *)malloc(arr_size * sizeof(int));

    for (int i = 0; i < arr_size; i++) {
        sums[i] = func(arr_2d[i], row_sizes[i]);
    }

    return sums;
}

// Main function to test the implementation
int main() {
    // Example 2D array
    int row1[] = {1, 2, 3};
    int row2[] = {4, 5, 6};
    int row3[] = {7, 8, 9};
    int *arr_2d[] = {row1, row2, row3};
    int row_sizes[] = {3, 3, 3};
    int arr_size = 3;

    CallbackFunc callback = process_2d_array;
    int *sums = callback(arr_2d, arr_size, row_sizes, sum_array);

    printf("Sums of each row:\n");
    for (int i = 0; i < arr_size; i++) {
        printf("Sum of row %d: %d\n", i + 1, sums[i]);
    }

    free(sums);

    return 0;
}
