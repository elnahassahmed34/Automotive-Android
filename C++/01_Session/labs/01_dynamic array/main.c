#include <stdio.h>
#include <stdlib.h>

int main() {
    int initial_size = 5;
    int *dynamic_array = (int *)malloc(initial_size * sizeof(int));

    if (dynamic_array == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    // Initialize array with some values
    for (int i = 0; i < initial_size; i++) {
        dynamic_array[i] = i + 1;
    }

    // Print initial array
    printf("Initial array: ");
    for (int i = 0; i < initial_size; i++) {
        printf("%d ", dynamic_array[i]);
    }
    printf("\n");

    // Resize the array
    int new_size = 10;
    int *temp = (int *)realloc(dynamic_array, new_size * sizeof(*temp));
    if (temp == NULL) {
        printf("Memory reallocation failed!\n");
        free(dynamic_array); // Free the original array before exiting
        return 1;
    } else {
        dynamic_array = temp;
    }

    // Initialize the new elements
    for (int i = initial_size; i < new_size; i++) {
        dynamic_array[i] = i + 1;
    }

    // Print resized array
    printf("Resized array: ");
    for (int i = 0; i < new_size; i++) {
        printf("%d ", dynamic_array[i]);
    }
    printf("\n");

    // Add a new element
    int element_to_add = 11;

    // Increase size by 1
    int final_size = new_size + 1;
    temp = (int *)realloc(dynamic_array, final_size * sizeof(*temp));
    if (temp == NULL) {
        printf("Memory reallocation failed!\n");
        free(dynamic_array); // Free the original array before exiting
        return 1;
    } else {
        dynamic_array = temp;
    }

    // Add the new element
    dynamic_array[final_size - 1] = element_to_add;

    // Print final array
    printf("Final array: ");
    for (int i = 0; i < final_size; i++) {
        printf("%d ", dynamic_array[i]);
    }
    printf("\n");

    // Free the allocated memory
    free(dynamic_array);

    return 0;
}
