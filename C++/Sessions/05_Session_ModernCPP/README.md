# C++ Programming Concepts

## Initializer List
- std::initializer_list
- std::initializer_list provides a way to initialize containers and objects with a list of values. 
- It's often used in constructors to initialize class members.

```cpp
#include <initializer_list>
#include <iostream>
#include <vector>

class MyClass {
public:
    MyClass(std::initializer_list<int> list) {
        for (auto elem : list) {
            data.push_back(elem);
        }
    }

    void print() const {
        for (auto elem : data) {
            std::cout << elem << " ";
        }
        std::cout << std::endl;
    }

private:
    std::vector<int> data;
};

int main() {
    MyClass obj = {1, 2, 3, 4, 5};
    obj.print();  // Output: 1 2 3 4 5
    return 0;
}
```

## Default Function Arguments
- Default function arguments allow you to specify default values for parameters. 
- This means that if a parameter is not provided, the default value is used.

Example
```cpp
#include <iostream>

void print(int x = 10) {
    std::cout << x << std::endl;
}

int main() {
    print();    // Prints 10
    print(20);  // Prints 20
    return 0;
}
```

## Ambiguity with Overloading
- Be cautious when using default arguments in overloaded functions, as it can lead to ambiguity.

```cpp
#include <iostream>

// Ambiguous function calls with default arguments
void print(int x = 10) {
    std::cout << x << std::endl;
}

void print() {
    std::cout << "Default print" << std::endl;
}

int main() {
    // print();  // Error: Ambiguous call
    print(20);  // Prints 20
    return 0;
}
```

## const and constexpr

### const
- The const keyword is used to define constant values that cannot be modified after initialization. 
- It can be used with variables, pointers, and member functions.

```cpp
#include <iostream>

void print(const int &var) {
    std::cout << var << std::endl;
}

int main() {
    const int x = 10;
    print(x);  // Prints 10
    print(20); // Prints 20
    return 0;
}
```
### constexpr
- The constexpr keyword is used to declare functions and variables that can be evaluated at compile time. 
- It is particularly useful for defining constants and recursive functions.

```cpp
#include <iostream>

constexpr int factorial(int n) {
    return (n <= 1) ? 1 : (n * factorial(n - 1));
}

int main() {
    constexpr int result = factorial(5);
    std::cout << "Factorial of 5 is: " << result << std::endl;  // Output: Factorial of 5 is: 120
    return 0;
}
```

## Inline Function
- Inline functions are defined with the inline keyword and can be expanded at the point of call, potentially reducing the overhead of function calls.

```cpp
#include <iostream>

inline void f() {
    std::cout << "Hi" << std::endl;
}

int main() {
    f();  // Output: Hi
    return 0;
}
```
### Always Inline
- The __attribute__((always_inline)) specifier forces the compiler to inline a function.

```cpp
#include <iostream>

inline __attribute__((always_inline)) void f() {
    std::cout << "Hi" << std::endl;
}

int main() {
    f();  // Output: Hi
    return 0;
}
```
## Lvalue and Rvalue
### Move Semantics
- Move semantics allow the resources of temporary objects to be moved rather than copied. 
- This is useful for optimizing performance, especially when dealing with large objects or containers.

```cpp
#include <iostream>
#include <vector>

void printVector(std::vector<int> &&vec) {
    for (int x : vec) {
        std::cout << x << " ";
    }
    std::cout << std::endl;
}

int main() {
    std::vector<int> vec = {1, 2, 3, 4, 5};
    printVector(std::move(vec));  // Moves vec
    return 0;
}
```

### C-Style String is an Lvalue
- In C++, a C-style string (array of characters) is an lvalue because it refers to a specific memory location.

```cpp
#include <iostream>

int main() {
    char str[] = "Hello";
    char &ref = str[0];  // ref is an lvalue reference to the first character of str
    ref = 'h';
    std::cout << str << std::endl;  // Output: hello
    return 0;
}
```

## References
### Lvalue Reference
- Lvalue references can bind to lvalues (variables with a specific memory location).

```cpp
#include <iostream>

int main() {
    int x = 10;
    int &Lref = x;
    Lref = 20;
    std::cout << "x: " << x << std::endl;  // Output: x: 20
    return 0;
}
```

### Rvalue Reference
- Rvalue references can bind to rvalues (temporary objects).

```cpp
#include <iostream>

int main() {
    int &&Rref = 10;
    std::cout << "Rref: " << Rref << std::endl;  // Output: Rref: 10
    return 0;
}
```
### Reference to Pointer
- You can create references to pointers.

```cpp
#include <iostream>

int main() {
    int x = 10;
    int *p = &x;
    int *&pref = p;
    *pref = 20;
    std::cout << "x: " << x << std::endl;  // Output: x: 20
    return 0;
}
```

### Reference with auto
- auto can deduce the type of a reference.

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto &ref = x;
    ref = 20;
    std::cout << "x: " << x << std::endl;  // Output: x: 20
    return 0;
}
```

## print(const int &var)
- You can pass both lvalues and rvalues to a function that takes a const lvalue reference.

```cpp
#include <iostream>

void print(const int &var) {
    std::cout << var << std::endl;
}

int main() {
    int x = 10;
    print(x);  // Prints 10 (lvalue)
    print(20); // Prints 20 (rvalue)
    return 0;
}
```

