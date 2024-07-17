# C++ Concepts

## Lambda Expressions
Lambda expressions are a feature introduced in C++11 that allow you to define anonymous functions or closures. They are particularly useful for creating short, throwaway functions that can be used locally.

### Syntax
The syntax for a lambda expression is as follows:

```cpp
[capture](parameters) -> return_type { 
    // function body 
}
```
- Capture List: [capture] specifies which variables from the surrounding scope are captured and how.
- Parameters: (parameters) defines the parameters of the lambda.
- Return Type: -> return_type specifies the return type of the lambda. It can be omitted if the - return type can be inferred.
- Function Body: { /* body */ } is where the actual code of the lambda goes.

### Examples
Basic Lambda Expression
```cpp
#include <iostream>

int main() {
    // Lambda that takes no parameters and returns void
    auto greet = []() {
        std::cout << "Hello, World!" << std::endl;
    };

    greet();  // Call the lambda
    return 0;
}
```
### Lambda with Parameters
```cpp
#include <iostream>

int main() {
    // Lambda that takes two integers and returns their sum
    auto add = [](int a, int b) -> int {
        return a + b;
    };

    std::cout << "Sum: " << add(5, 3) << std::endl;  // Outputs: Sum: 8
    return 0;
}
```
### Lambda Capturing Variables
```cpp
#include <iostream>

int main() {
    int x = 10;
    // Lambda capturing x by value
    auto printX = [x]() {
        std::cout << "x: " << x << std::endl;
    };

    printX();  // Outputs: x: 10

    // Lambda capturing x by reference
    auto modifyX = [&x]() {
        x += 5;
    };

    modifyX();
    std::cout << "Modified x: " << x << std::endl;  // Outputs: Modified x: 15

    return 0;
}
```
### Lambda Expressions vs Functors
A functor (or function object) is a class or struct that overloads the operator(), allowing it to be used as if it were a function. Lambdas can be seen as a more concise way to achieve the same result without defining a separate class.

Functor Example:

```cpp
#include <iostream>

class Adder {
public:
    Adder(int x) : x_(x) {}
    int operator()(int y) const {
        return x_ + y;
    }

private:
    int x_;
};

int main() {
    Adder add10(10);
    std::cout << "Result: " << add10(5) << std::endl;  // Outputs: Result: 15
    return 0;
}
```
### Lambda Equivalent:

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto add = [x](int y) -> int {
        return x + y;
    };

    std::cout << "Result: " << add(5) << std::endl;  // Outputs: Result: 15
    return 0;
}
```
## Exception Handling
Exception handling in C++ provides a mechanism to handle runtime errors. It involves the use of try, catch, and throw keywords to manage exceptions that occur during program execution.

### Basic Syntax
```cpp
try {
    // Code that might throw an exception
    throw SomeException();
} catch (const SomeExceptionType& e) {
    // Code to handle the exception
}
```
- try Block: Contains code that may throw an exception.
- catch Block: Handles the exception. Multiple catch blocks can be used to handle different types of exceptions.
Example
```cpp
#include <iostream>
#include <stdexcept> // For std::runtime_error

int main() {
    try {
        int a = 10;
        int b = 0;
        
        if (b == 0) {
            throw std::runtime_error("Division by zero");  // Throwing an exception
        }
        
        int x = a / b;
        std::cout << x << std::endl;
    } catch (const std::runtime_error& e) {
        std::cout << "Caught exception: " << e.what() << std::endl;  // Handling the exception
    }

    return 0;
}
```
### Stack Unwinding
When an exception is thrown, C++ performs stack unwinding. This means that the runtime will clean up the stack by calling destructors for objects that were created in the scope of the try block, but not yet destroyed.

Stack Unwinding: If there is no appropriate catch block, the exception propagates up the call stack. The stack frames are removed, and destructors for all local objects are called until a catch block is found or the program terminates.
Example of Stack Unwinding

```cpp
#include <iostream>

void functionB() {
    throw std::runtime_error("Error in functionB");
}

void functionA() {
    functionB();
}

int main() {
    try {
        functionA();
    } catch (const std::runtime_error& e) {
        std::cout << "Caught exception: " << e.what() << std::endl;
    }

    return 0;
}

```