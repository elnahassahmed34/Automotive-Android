# C++ Object-Oriented Programming (OOP) README

## Table of Contents
1. [Classes](#classes)
    - [Attributes](#attributes)
    - [Functions](#functions)
2. [Objects or Instances](#objects-or-instances)
    - [Declaration](#declaration)
3. [Core Concepts](#core-concepts)
    - [Encapsulation](#encapsulation)
    - [Inheritance](#inheritance)
    - [Polymorphism](#polymorphism)
4. [Principles](#principles)
    - [Modularity](#modularity)
    - [Abstraction](#abstraction)

## Classes

### Attributes
Classes can contain attributes, which are variables that hold data specific to the class.

### Functions
Classes can also contain functions, which define behaviors or actions that the class can perform.

```cpp
class DIO {
public:
    struct Registers {
        // Define register attributes here
    } DIO;

    void SetPin() {
        // Set pin logic here
    }

    void SetPinMode() {
        // Set pin mode logic here
    }

    void SetPinValue() {
        // Set pin value logic here
    }
};
```

## Objects or Instances
### Declaration
- Objects or instances are created from classes. Declaring a class does not take memory until an instance is made.

```cpp
DIO dioInstance;
```
## Core Concepts

### Encapsulation
- Encapsulation involves bundling data and methods that operate on the data within one unit, such as a class, and restricting access to some of the object's components.

- Example: Avoid using global variables.

### Inheritance
- Inheritance allows a class to inherit attributes and methods from another class. This helps in reusing existing code.

``` cpp
Copy code
class ARM : public DIO {
    // ARM-specific functionality here
};
```

### Polymorphism
- Polymorphism allows methods to do different things based on the object it is acting upon, even if they share the same name.

## Principles
### Modularity
- Modularity makes debugging and maintenance easier by dividing the program into separate modules that can be developed, tested, and debugged independently.

### Abstraction
- Abstraction means hiding the complex implementation details and showing only the necessary features of an object.

- You do not need to care about the implementation details when you use an object.
# C++ Constructors and Destructors README

## Table of Contents
1. [Constructors](#constructors)
    - [Default Constructor (Implicit)](#default-constructor-implicit)
    - [Default Constructor (Explicit)](#default-constructor-explicit)
    - [Parameterized Constructor](#parameterized-constructor)
2. [Destructors](#destructors)
3. [Member Initialization List](#member-initialization-list)
4. [Delegating Constructors](#delegating-constructors)

## Constructors

### Default Constructor (Implicit)
The default constructor is created by the compiler if no other constructors are defined. It initializes variables and attributes to zero or their default values.

- If three objects of the same class are created, different attributes will be initialized, but the same functions will be invoked.

```cpp
class DIO {
    int x;
    int y;

public:
    DIO() = default; // Implicit default constructor
    void setPinValue();
};
```
### Default Constructor (Explicit)
- The default constructor can be explicitly defined by the programmer to initialize variables with specific values.

```cpp
class DIO {
    int x;
    int y;

public:
    DIO() : x(3), y(0) {} // Explicit default constructor
};
```
### Parameterized Constructor
- A parameterized constructor allows initializing objects with specific values.

```cpp
class DIO {
    int x;
    int y;

public:
    DIO(int x, int y) : x{x}, y{y} {} // Parameterized constructor
};
```
- If you provide a parameterized constructor, the compiler will not generate a default constructor.

#### Example with Pointer
```cpp
struct Registers {
    // Define register attributes here
};

class DIO {
    Registers* register;

public:
    DIO(Registers* reg) : register{reg} {} // Parameterized constructor with pointer
};
```
### Destructors
- Destructors are used to free resources when an object goes out of scope or is explicitly deleted.
- They help prevent memory leaks by freeing dynamic memory, closing files, releasing resources, and closing connections.

- A destructor is called in two ways: at the end of the scope or using the delete keyword.
```cpp
class DIO {
public:
    ~DIO() {
        // Free resources here
    }
};
```
### Member Initialization List
- Member initialization lists are used to initialize member variables before the constructor body executes.

```cpp
class DIO {
    const int x;
    int y;

public:
    DIO() : x(3), y(0) {} // Member initialization list
};
```
### Delegating Constructors
- Delegating constructors allow one constructor to call another constructor within the same class.

```cpp
class DIO {
    int x;
    int y;

public:
    DIO() : x(0), y(0) {} // Default constructor

    DIO(int x, int y) : DIO() { // Delegating constructor
        this->x = x;
        this->y = y;
    }
};
```
#### Example Code
```cpp
#include <iostream>

using namespace std;

class DIO {
public:
    const int x;
    int y;

    DIO() : x(3), y(0) { // Member initialization list
        // Initialization code
    }
};

int main() {
    DIO dio;
    cout << "x: " << dio.x << ", y: " << dio.y << endl;
    return 0;
}
```


# C++ Copy Constructor README

## Copy Constructor

A copy constructor in C++ is used to create a new object as a copy of an existing object. The compiler can generate it implicitly, and by default, it makes a shallow copy.

### Shallow Copy

A shallow copy duplicates an object's members as-is, meaning if an object contains pointers, the copied object will point to the same memory addresses. This can lead to issues such as dangling pointers if the original object is destroyed and the copied object still tries to access the freed memory.

```cpp
class DIO {
    int* data;

public:
    DIO() {
        data = new int(5);
        std::cout << "Default constructor" << std::endl;
    }

    // Shallow copy constructor
    DIO(const DIO& copy) {
        data = copy.data;
        std::cout << "Shallow copy constructor" << std::endl;
    }

    ~DIO() {
        delete data;
        std::cout << "Destructor" << std::endl;
    }

    void printData() const {
        std::cout << "Data: " << *data << std::endl;
    }
};
```

### Deep Copy
- A deep copy duplicates all the members of the object, including allocating new memory for pointers and copying the data they point to.
- this avoids the issues of dangling pointers by ensuring each object has its own copy of the dynamically allocated memory.

```cpp
class DIO {
    int* data;

public:
    DIO() {
        data = new int(5);
        std::cout << "Default constructor" << std::endl;
    }

    // Deep copy constructor
    DIO(const DIO& copy) {
        data = new int(*copy.data);
        std::cout << "Deep copy constructor" << std::endl;
    }

    ~DIO() {
        delete data;
        std::cout << "Destructor" << std::endl;
    }

    void printData() const {
        std::cout << "Data: " << *data << std::endl;
    }
};
```
## Comparison Between Shallow Copy and Deep Copy
### Shallow Copy:

- Copies the memory address, not the actual data.
- Both the original and copied object share the same memory.
- Can lead to dangling pointers and undefined behavior if one object is destroyed.

### Deep Copy:

- Allocates separate memory and copies the actual data.
- Each object has its own copy of the dynamically allocated memory.
- Safer and prevents issues related to shared memory.



# Static Variable in Class README

## Overview
A static variable in a class is a class-level variable shared among all instances of that class. It is stored in the `.data` segment of RAM, allowing it to be accessed and modified.

### Characteristics of Static Variables
- **Shared Among All Objects**: All instances of the class share the same static variable.
- **Stored in .data Segment**: Static variables are stored in the `.data` segment of RAM.

### Example
Here's an example of defining and using a static variable in a class:

```cpp
class DIO {
    static int mystatic; // Declaration of static variable
};

// Definition and initialization of static variable
int DIO::mystatic = 2;
```

## Accessing Static Variables
- Static variables can be accessed and modified by any non-static member function of the class:

```cpp
void nonStaticFunction() {
    DIO::mystatic++;
    std::cout << "Static variable value: " << DIO::mystatic << std::endl;
}
```
## Static Functions
- Static functions can access static variables and global variables but cannot access non-static member variables directly.

```cpp
class DIO {
    static int mystatic;
    int nonStaticVar;

public:
    static void staticFunction() {
        mystatic++;
        // Cannot access nonStaticVar directly
    }
};
// Definition and initialization of static variable
int DIO::mystatic = 2;
```
## Summary
- Static variables in a class are shared among all objects and are stored in the .data segment of RAM.
- They can be accessed by any non-static member function.
- Static functions can only access static variables and global variables.

