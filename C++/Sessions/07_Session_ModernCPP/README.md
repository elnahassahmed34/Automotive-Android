# C++ Concepts

## I/O Streams
- Unbuffered Output vs Buffered Output
- Unbuffered Output: Data is written directly to the output device as soon as it is available. 

- This means each output operation may be slower since it directly interacts with the hardware. Example: std::cerr (used for error messages) is usually unbuffered.

- Buffered Output: Data is first stored in a buffer and written to the output device in larger chunks. 
- This reduces the number of interactions with the hardware, which can improve performance. However, the output might not appear immediately unless the buffer is flushed. Example: std::cout is buffered.

### Flushing the Buffer:
Sometimes, it is necessary to flush the buffer to ensure that all buffered data is written out immediately. This can be done using std::flush or std::endl (which also inserts a newline).
Example
```cpp
#include <iostream>

int main() {
    std::cout << "Buffered output, will be delayed" << std::endl; // Automatically flushes
    std::cerr << "Unbuffered output, appears immediately\n"; // No buffering
    return 0;
}
```

## Manipulators
1. setw()
- Sets the width of the next input/output field. It only affects the next element to be printed.
2. setfill()
- Sets the character to be used to fill the empty spaces when using setw().
3. setprecision()
- Sets the number of digits to be printed for floating-point values. It affects all subsequent floating-point outputs.

Example
```cpp
#include <iostream>
#include <iomanip> // For manipulators

int main() {
    int num = 42;
    double pi = 3.14159;

    std::cout << std::setw(10) << std::setfill('*') << num << std::endl;
    std::cout << std::setprecision(3) << pi << std::endl;
    
    return 0;
}
```

## File I/O
1. fstream
- Used for both input and output operations.
2. ifstream
- Used for input operations only.
3. ofstream
- Used for output operations only.
