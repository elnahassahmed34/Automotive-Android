# OOP in C++
## Temporary Objects
In C++, temporary objects (also known as rvalues) can be passed to functions in various ways:

```cpp
void function(Example &&e){}          // valid, takes an rvalue reference
void function(Example e){}            // valid, takes by value
void function(const Example &e){}     // valid, takes a const lvalue reference
void function(Example &e){}           // not valid, requires an lvalue

int main(){
    function(Example());              // valid for rvalue reference, by value, and const lvalue reference
    return 0;
}
```
## RVO (Return Value Optimization)
RVO is a compiler optimization that eliminates the temporary object created when a function returns a value, effectively bypassing the copy and destructor calls.

## Friend Class and Function
Friend classes and functions have access to the private and protected members of the class in which they are declared as friends.

## Priority for Initialization
When initializing an object with {}:

- A a{1,3}; will use the initializer list A{std::initializer_list}.
- If an initializer list is not available, it will use the parameterized constructor A(int x, int y).
- For A a(1,3);, the compiler will search for a parameterized constructor A(int x, int y).

## delete and const
delete keyword is used to disable certain functions or constructors, especially copy constructors and copy assignment operators. const ensures that the value of a variable cannot be modified.

## Inheritance
- Single Inheritance: A class inherits from one base class.
- Multiple Inheritance: A class inherits from more than one base class.
- Multilevel Inheritance: A class inherits from another derived class.
- Hybrid Inheritance: A combination of two or more types of inheritance.

## Design
- Common and Unique Properties: Identify properties shared among classes and those unique to each class.
- Inheritance (Is-a Relationship): Use when one class is a type of another class.
- Composition (Has-a Relationship): Use when a class is composed of one or more objects of other classes.
- Aggregation: Represents a "whole-part" relationship where the part can exist independently of the whole.
```cpp
class A {};
class B { A* a; };
```

## Privacy Specifiers
- Public: Members are accessible from outside the class.
- Protected: Members are accessible within the class and its derived classes.
- Private: Members are accessible only within the class.

## Override Concept
- Polymorphism: Allows methods to do different things based on the object it is acting upon.
Virtual Keyword: Used to create a virtual table enabling dynamic binding.

## Pure Virtual Function and Abstract Class
A pure virtual function is a function with no implementation that must be overridden in derived classes. A class with one or more pure virtual functions is considered abstract and cannot be instantiated.