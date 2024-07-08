## Structs in C++

- Structures (structs) in C++ allow you to define a composite data type that groups together variables of different types under a single name. 
- Unlike classes, structs default to public access.

Example:
```cpp
struct Point {
    int x;
    int y;
};
```

## Enum in C++: Unscoped vs Scoped
- Enums in C++ are used to define a set of named integral constants. 
- Unscoped enums do not have their names enclosed in a scope, whereas scoped enums do.

Example:

```cpp
// Unscoped enum
enum Color {
    Red, Green, Blue
};

// Scoped enum
enum class Status {
    Active, Inactive
};
```

## Containers in C++
- Containers in C++ refer to classes that hold collections of other objects. Examples include vector, list, map, and set, provided by the Standard Template Library (STL).

### Arrays in C++
- Arrays in C++ allow you to store multiple values of the same type sequentially in memory. 
- They are a fundamental data structure and are often used when you know the size of the data in advance.

Example:

```cpp
int arr[5] = {1, 2, 3, 4, 5};
```
### Strings in C Style and C++
- Strings in C are represented as arrays of characters, terminated by a null character ('\0'). 
- C++ introduced the std::string class in the Standard Library, providing a safer and more flexible alternative to C-style strings.

Example:

```cpp
// C-style string
char str[] = "Hello";

// C++ string
std::string cppStr = "Hello, C++";
```
### String View Over Reference
- std::string_view in C++ is a non-owning view of a string, providing a read-only interface to a contiguous sequence of characters. 
- It is efficient for passing strings to functions without unnecessary copying.

Example:

```cpp
std::string_view view = "Hello, World!";
```

## UTF-8
- UTF-8 is a variable-width character encoding capable of encoding all possible characters in Unicode. 
- It is widely used in C++ for handling internationalization and multi-language text.

## Function Overloading
- Function overloading in C++ allows you to define multiple functions with the same name but different parameter lists. 
- The compiler determines which function to call based on the number and types of arguments passed.

Example:

``` cpp
Copy code
void print(int x) {
    std::cout << "Integer: " << x << std::endl;
}

void print(double x) {
    std::cout << "Double: " << x << std::endl;
}
```

## Templates: Implicit vs Explicit
- Templates in C++ enable you to write generic functions and classes that work with any data type. 
- Implicit instantiation occurs when the compiler automatically generates code for template functions/classes, 
- while explicit instantiation is when you explicitly tell the compiler to generate code for specific types.

Example:

```cpp
// Implicit instantiation
template<typename T>
void swap(T& a, T& b) {
    T temp = a;
    a = b;
    b = temp;
}

// Explicit instantiation
template void swap<int>(int&, int&);
```
### Template Specialization

- Template specialization allows you to provide a different implementation for a template when a specific data type is used.

- Types : Function , Templates and partial 

Example:

```cpp
template<>
class Pair<std::string, char> {
    // Specialized implementation for Pair<std::string, char>
};
```

## Name Mangling
- Name mangling is a compiler technique used to encode additional information (such as function signatures) into the names of symbols in compiled code. 
- It supports features like function overloading by ensuring each symbol has a unique name reflecting its type and context.

