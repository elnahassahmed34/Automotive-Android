# C++ Concepts

## Pass by Value vs Pass by Address vs Pass by Reference

### Pass by Value
- When a function is called with pass by value, a copy of the actual parameter is passed to the function.
- Modifications to the parameter inside the function do not affect the original argument.
- Example:
```cpp
  void increment(int num) {
      num++;
  }

  int main() {
      int a = 5;
      increment(a);
      // a remains 5
  }
```
### Pass by Address (Pointer)
- When a function is called with pass by address, the address of the actual parameter is passed to the function.
- Modifications to the parameter inside the function affect the original argument.
Example:
```cpp
void increment(int *num) {
    (*num)++;
}

int main() {
    int a = 5;
    increment(&a);
    // a becomes 6
}
```
### Pass by Reference
- When a function is called with pass by reference, the reference to the actual parameter is passed to the function.
- Modifications to the parameter inside the function affect the original argument.
Example:
```cpp
void increment(int &num) {
    num++;
}

int main() {
    int a = 5;
    increment(a);
    // a becomes 6
}
```
## Function Pointers and Callback Functions
### Function Pointers
- Function pointers allow you to store the address of a function and call it later.
Syntax:
```cpp
int (*funcPtr)(int, int);
//example
int add(int a, int b) {
    return a + b;
}

int main() {
    int (*funcPtr)(int, int) = &add;
    int result = funcPtr(2, 3);
    // result is 5
}
```
### Typedef for Function Pointers
Typedef can simplify the syntax of function pointers.
Example:
```cpp
typedef int (*FuncPtr)(int, int);

int add(int a, int b) {
    return a + b;
}

int main() {
    FuncPtr funcPtr = &add;
    int result = funcPtr(2, 3);
    // result is 5
}
```
### Callback Functions
Callback functions are used to pass a function as an argument to another function.
Example:
```cpp
void process(int (*callback)(int, int)) {
    int result = callback(2, 3);
    // result is 5
}

int add(int a, int b) {
    return a + b;
}

int main() {
    process(&add);
}
```
## Debugging with g++
### Compiling with Debug Information
- Use the -g flag with g++ to include debugging information in the compiled executable.
- This information includes symbol tables and allows you to use debugging tools like gdb.
Example:
```sh
g++ -g -o my_program my_program.cpp
```

### Debugging with gdb
### Starting gdb
- To start gdb with an executable:
```sh
gdb ./my_program
```
### Basic gdb Commands
- run : Start running the program.
- break <line_number> or break <function_name>: Set a breakpoint.
- next : Execute the next line of code (step over).
- step : Step into the function.
- continue : Continue running the program until the next breakpoint.
- print <variable>: Print the value of a variable.
- quit : Exit gdb.

#### Example gdb Session
```sh
gdb ./my_program
(gdb) break main
(gdb) run
(gdb) next
(gdb) print a
(gdb) continue
(gdb) quit
```