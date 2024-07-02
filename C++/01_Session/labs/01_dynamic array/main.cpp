#include <iostream>

int main() {
    int initial_size = 5;
    int* dynamic_array = new int[initial_size];

    // Initialize array with some values
    for (int i = 0; i < initial_size; i++) {
        dynamic_array[i] = i + 1;
    }

    // Print initial array
    std::cout << "Initial array: ";
    for (int i = 0; i < initial_size; i++) {
        std::cout << dynamic_array[i] << " ";
    }
    std::cout << std::endl;

    // Resize the array
    int new_size = 10;
    int* temp = new int[new_size];

    // Copy the old elements to the new array
    for (int i = 0; i < initial_size; i++) {
        temp[i] = dynamic_array[i];
    }

    // Initialize the new elements
    for (int i = initial_size; i < new_size; i++) {
        temp[i] = i + 1;
    }

    // Delete the old array
    delete[] dynamic_array;

    // Point to the new array
    dynamic_array = temp;

    // Print resized array
    std::cout << "Resized array: ";
    for (int i = 0; i < new_size; i++) {
        std::cout << dynamic_array[i] << " ";
    }
    std::cout << std::endl;

    // Add a new element
    int element_to_add = 11;

    // Increase size by 1
    int final_size = new_size + 1;
    temp = new int[final_size];

    // Copy the old elements to the new array
    for (int i = 0; i < new_size; i++) {
        temp[i] = dynamic_array[i];
    }

    // Add the new element
    temp[final_size - 1] = element_to_add;

    // Delete the old array
    delete[] dynamic_array;

    // Point to the new array
    dynamic_array = temp;

    // Print final array
    std::cout << "Final array: ";
    for (int i = 0; i < final_size; i++) {
        std::cout << dynamic_array[i] << " ";
    }
    std::cout << std::endl;

    // Free the allocated memory
    delete[] dynamic_array;

    return 0;
}
