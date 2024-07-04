# C++ Concepts

## Fragmentation: Internal vs External

### Internal Fragmentation
- Occurs when memory is allocated in fixed-sized blocks and the allocated memory may be slightly larger than the requested memory.
- The extra allocated memory within the block remains unused, leading to wasted space.
- Example:
  - If memory is allocated in fixed blocks of 64 bytes and a program requests 60 bytes, 4 bytes are wasted.

### External Fragmentation
- Occurs when free memory is split into small blocks scattered throughout the memory.
- Even though the total free memory might be sufficient, it may not be contiguous, leading to allocation failures for larger memory requests.
- Example:
  - A program deallocates memory in different locations, creating non-contiguous free blocks.

## Time and Space Complexity

### Time Complexity
- Measures the amount of time an algorithm takes to complete as a function of the input size.
- Common notations:
  - O(1): Constant time
  - O(log n): Logarithmic time
  - O(n): Linear time
  - O(n log n): Linearithmic time
  - O(n^2): Quadratic time
  - O(2^n): Exponential time
- Example:
```cpp
  void exampleFunction(int n) {
      for (int i = 0; i < n; i++) { // O(n)
          for (int j = 0; j < n; j++) { // O(n)
              // Some constant time operations O(1)
          }
      }
  }
  // Overall time complexity: O(n^2)
```

### Space Complexity
- Measures the amount of memory an algorithm uses as a function of the input size.
- Includes space for input, output, and auxiliary storage.
Example:
```cpp
void exampleFunction(int n) {
    int arr[n]; // O(n) space for the array
    for (int i = 0; i < n; i++) {
        // Some operations
    }
}
// Overall space complexity: O(n)
```
### Stack Buffer Overflow
#### Definition
- Occurs when a program writes more data to a buffer located on the stack than what is allocated for that buffer.
- This can overwrite adjacent memory, leading to undefined behavior, crashes, or security vulnerabilities.
Example
```cpp
void vulnerableFunction() {
    char buffer[10];
    strcpy(buffer, "This is a very long string that exceeds the buffer size.");
    // This will cause a buffer overflow
}

int main() {
    vulnerableFunction();
    return 0;
}
```
#### Prevention
- Use functions that limit the amount of data copied, such as strncpy instead of strcpy.
- Perform bounds checking before writing data to buffers.
- Use modern C++ constructs like std::string that handle memory management automatically.

## Reverse Engineering
### Definition
- The process of analyzing a software system to extract design and implementation information.
- Used to understand how a program works, to find vulnerabilities, or to create compatible software.
### Techniques
- Static Analysis: Analyzing the code without executing it. Tools like disassemblers (e.g., IDA Pro) are commonly used.
- Dynamic Analysis: Analyzing the code during execution. Tools like debuggers (e.g., gdb) and profilers are used.
Example
- Disassembling: Converting executable code back into assembly code to understand the program flow.
- Debugging: Running the program under a debugger to inspect the state of the application at runtime.
### Tools
- IDA Pro: Interactive Disassembler, a powerful tool for static analysis.
- gdb: GNU Debugger, used for dynamic analysis and debugging.
- OllyDbg: An assembler-level debugger for Windows.
### Legal and Ethical Considerations
- Ensure you have the legal right to reverse engineer the software.
- Be aware of software licenses and intellectual property laws.