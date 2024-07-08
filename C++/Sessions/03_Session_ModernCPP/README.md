# Differences Between C++ Standards

## C++98
- **Templates**: Introduced template support for generic programming.
- **STL with Containers and Algorithms**: Standard Template Library (STL) provided containers (like vector, list) and algorithms (like sort, find).
- **Strings**: Basic string manipulation capabilities.
- **IO Streams**: Input and output operations via streams.

## C++11
- **Move Semantics**: Efficient transfer of resources from one object to another.
- **Unified Initialization**: Uniform initialization syntax with braces `{}`.
- **auto and decltype**: Automatic type deduction.
- **Lambda Expressions**: Inline anonymous functions.
- **constexpr**: Generalized constant expressions.

- **Threading and Memory Model**: Support for multithreading with standard library threading facilities.

## C++14
- **Reader-Writer Locks**: Synchronization mechanism for shared data.
- **Generic Lambda Functions**: Lambda functions with templated parameters.

## C++17
- **Fold Expressions**: Parameter pack expansions.
- **constexpr if**: Compile-time conditional statements.
- **Structured Binding**: Decomposing structured bindings.

- **std::string_view**: Non-owning view of a string.
- **Parallel Algorithms of the STL**: Parallel execution of standard algorithms.
- **Filesystem Library**: Operations on file systems.
- **std::any, std::optional, and std::variant**: Enhancements to handle optional and variant types.

## C++20
- **Coroutines**: Cooperative multitasking functions.
- **Modules**: Modularization of code.
- **Concepts**: Constraints on templates with concepts.
- **Ranges Library**: Operations on sequences of elements.

## C++23
- **Deducing `this`**: Deduction of `this` pointer in member functions.
- **Modularized Standard Library**: Modular approach to the standard library.
- **Print and Println**: Output formatting improvements.
- **Flat Associative Containers**: Containers optimized for associative access.
- **std::expected**: Expected monad for error handling.
- **Improved Ranges**: Enhancements to the Ranges library.
- **std::mdspan**: Multidimensional array span.
- **std::generator**: Coroutine generator support.

# C++ Concepts README

## Namespace

### Named Namespace
Namespaces provide a way to organize code into logical groups and prevent naming conflicts.
```cpp
namespace MyLibraries {
    namespace Networking {
        namespace FTP {
            // FTP-related code
        }
    }
}
```

### Unnamed Namespace (Private Linkage)
- An unnamed namespace restricts the visibility of its contents to the current translation unit.

```cpp
namespace {
    int internalVariable = 10;
}
```

### Type Alias
#### Alias Declaration
- Type aliases provide alternative names for existing types, improving code readability.

```cpp
namespace MyFTP = MyLibraries::Networking::FTP;
```

### Variable Initialization
```cpp
#Copy Initialization
#Uses the assignment operator = for initialization.
int x = 5;

#Direct Initialization
#Uses parentheses () for initialization.
int y(5);

#List Initialization (Uniform Initialization)
#Uses braces {} for initialization, preventing narrowing conversions and ensuring consistency.
int z{5};

#Aggregate Initialization
#Initialize aggregates (arrays and structs) using braces {}.
struct Point {
    int x;
    int y;
};

Point p = {1, 2};
```
### Why List Initialization?
- Prevents unintentional narrowing conversions and ensures uniform initialization syntax 
across types.

## Range-Based Loop
- Iterating Over Containers
- Simplifies iteration over containers like arrays, vectors, and other collections.

```cpp
std::vector<int> nums = {1, 2, 3};

for (int num : nums) {
    std::cout << num << " ";
}
```
## Dynamic Allocation (new)

```cpp
#Single Object Allocation
#Allocate a single object with dynamic memory.
int* p = new int{5};

#Array Allocation
#Allocate arrays of objects with dynamic memory.
int* arr = new int[5]{1, 2, 3, 4, 5};

#Array of Pointers Allocation
#Allocate an array of pointers to objects with dynamic memory.
// Dynamically allocate each array of integers
int* arr1 = new int[1]{1};
int* arr2 = new int[2]{2, 3};
int* arr3 = new int[1]{4};
int* arr4 = new int[2]{5, 6};
int* arr5 = new int[3]{7, 8, 9};

// Initialize dp as an array of pointers to int arrays
int** dp = new int*[5]{ arr1, arr2, arr3, arr4, arr5 };

// Deallocate each individual array of integers
for (int i = 0; i < 5; ++i) {
    delete[] dp[i];
}

// Deallocate the array of pointers
delete[] dp;
```
# Comparison: `new` vs `malloc`

| Feature            | `new`                                    | `malloc`                               |
|--------------------|------------------------------------------|----------------------------------------|
| Initialization     | Calls constructor (for non-POD types)     | No initialization                      |
| Type Safety        | Type-safe                                 | Not type-safe                          |
| Return Type        | Returns typed pointer                     | Returns `void*`, needs casting         |
| Size Adjustment    | Adjusts size automatically                | Requires manual adjustment (`sizeof`)  |
| Memory Alignment   | Ensures alignment for types               | No alignment guarantees                |

- Use new for C++ objects and malloc for raw memory in C or when interfacing with C libraries.


## Types of Casting

### Static Casting (`static_cast`)
- Used for compile-time type conversions.
- Ensures type safety by checking the type at compile-time.
- Commonly used for converting between related types, such as `int` to `float`.

```cpp
int main() {
    int a = 10;
    float b = static_cast<float>(a);
    return 0;
}
```

### Dynamic Casting (dynamic_cast)
- Used for runtime type conversions.
- Requires the base class to have at least one virtual function.
- Commonly used for safe downcasting in polymorphic hierarchies.
```cpp
#include <iostream>
using namespace std;

class Base {
    virtual void foo() {}
};

class Derived : public Base {};

int main() {
    Base* base = new Derived();
    Derived* derived = dynamic_cast<Derived*>(base);
    if (derived) {
        cout << "Dynamic cast successful" << endl;
    } else {
        cout << "Dynamic cast failed" << endl;
    }
    return 0;
}
```

## Linking & Scope
### No Linkage
- Variables with no linkage are unique to their scope.
```cpp
void foo() {
    int x = 5; // No linkage
}
```
### Internal Linkage
- Variables or functions with internal linkage are only accessible within the same translation unit.
```cpp
static int x = 5; // Internal linkage

static void foo() {
    // Function with internal linkage
}
```
### External Linkage
Variables or functions with external linkage can be accessed from other translation units.
```cpp
int x = 5; // External linkage

void foo() {
    // Function with external linkage
}
```
## Type Inference (auto)
### auto
- Automatically deduces the type of the variable from its initializer.
```cpp
int main() {
    auto x = 10;    // x is an int
    auto y = 5.5;   // y is a double
    return 0;
}
### decltype
- Deduces the type of a variable from another variable or expression.
```cpp
int x = 0;
decltype(x) y = 1; // y is of type int
```
### typeid
- Provides runtime type information.
```cpp
#include <iostream>
#include <typeinfo>

int main() {
    int a = 0;
    cout << "Type of a: " << typeid(a).name() << endl;
    return 0;
}
```
## pair (first, second)
- A container to store a pair of values.
```cpp
#include <iostream>
#include <utility>

int main() {
    std::pair<int, double> p(1, 2.5);
    std::cout << "First: " << p.first << ", Second: " << p.second << std::endl;
    return 0;
}
```
### Structured Binding
- Allows unpacking of tuples, pairs, or arrays into individual named variables.
```cpp
Copy code
int main() {
    int values[]{10, 20, 30};
    auto [x, y, z] = values;
    std::cout << "x: " << x << ", y: " << y << ", z: " << z << std::endl;
    return 0;
}
```
