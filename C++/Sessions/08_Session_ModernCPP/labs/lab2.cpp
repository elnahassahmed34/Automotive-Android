// #include <iostream>
// #include <stdexcept> // Include the header for standard exceptions

// using namespace std;

// int main() {

//     int arr[] = {1,23,4};
//     try {
//         int a = 10;
//         int b = 0;
        
//         if (b == 0) {
//             throw runtime_error("Division by zero"); // Manually throw an exception
//         }
        
//         int x = a / b;
//         cout << x << endl;
//     }
//     catch (const runtime_error& ex) { // Catch the runtime error exception
//         cout << ex.what() << endl; // Print the exception message
//     }

//     return 0;
// }

#include <iostream>
#include <vector>
#include <stdexcept> // Include the header for standard exceptions

using namespace std;

int main() {
    vector<int> arr = {1, 23, 4}; // Use std::vector for automatic bounds checking
    int index = 5; // The out-of-bounds index

    try {
        int value = arr.at(index); // This will automatically throw an exception if out of bounds
        cout << "Value: " << value << endl;
    }
    catch (const out_of_range& ex) { // Catch the out-of-range exception
        cout << ex.what() << endl; // Print the exception message
    }

    return 0;
}
