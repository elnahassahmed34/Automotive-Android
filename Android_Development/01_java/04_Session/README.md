# MOdifiers - Acces Specifiers
# Essential Java classes (Graphics - font - color - EXception classes)

## modifiers
- public   
    - classess access outside pkg
    - methods + vars accessed ouside class same pkg

- private
    - no private classes
    - private methods and vars inside class only

- protected
    - accessible inside class and through inhertance
    - accessed inside same pkg

- friendly
    - default access , pkg access
    - accessible within sasme pkg only

### example

- public class A -> pkg1
```
w
public x
protected y
private z
```
- class B inherit A
    - access w x y , but not z
- class B -> A a
    - access w x y but not z

- class D -> pkg2 -> import pkg1
    - access x y
    - but not w  z

## the second part
### - static
    - class member -> property of class , one time in memory
    - static method or var
        - static method -> utility method
        - any instance of class can access it
        - it doesn't change in the object itself (design)
    - or access static memeber
- free floating block
- equavilant c++ 
```cpp
#include <iostream>

class Myclass {
private:
    int x;
    static int y;

public:
    Myclass() : x(0) {
        std::cout << "Constructor" << std::endl;
    }

    static void initY(int yv) {
        y = yv;
    }

    // Static initializer in C++
    // This block simulates Java's static initializer
    static void staticInitializer() {
        std::cout << "Static Init" << std::endl;
        y = 5 + 6;
    }
};

// Define static member variable
int Myclass::y = 0;

// Call static initializer
static int dummy = (Myclass::staticInitializer(), 0);

int main() {
    Myclass m;
    Myclass m2;
    Myclass::initY(5);
    return 0;
}

```

### abstract
 - not completed class -> inherted and implemented


### final
- class can't be inherited
- method can't be overriden
- variable constant
- no const keyword
- it is the contrast of abstract

### native
- native method can be written in c or c++

### volatile + synchronized
- volatile variable
- 3 threads access same variable or method which access it
- synchronized method
- they acts as locks (mutex)


### transient
- hibernate for the object
- snapshot of object
- serialization -> change object to array of bytes
    - then create this object again in the same state
- if there is a thread running make it transient
    - so that it will not be transferred


## Graphics calss
- draw line , rect , oval 
- fill oval 

### - color(int r g b) class
- there are 13 predefined color objects injava
    - declared as public static final 
        - final refrence -> can't point to another object

### font class
- Font(String name , int style , int size);
    - style -> public tatic final
- set font

### toolkit class
- it is abstract class
- there will be static method return toolkit
    - public tatic Tollkit getDefaultToolkit();
- get font list 
    - depracted means a new method is implemented

## Exception
- an exception is object created during runtime
    - created when abnormal situation happened
    - runtime error

- examples -> two categries -> developer issue or not
    - open file doesn't exist
    - write file OS marked readonly
    - use ref = null
    - access array element beyond actual size 

- exception **thrown** when the proplem occurs
    - code which handle it will **catch** it

- Throwable has two class exception and error
- exception :
    - IOEXception not the issue of developer
        - Checked EXceptions
        - compilation error
            - until you provide exception handler
    - Runtime EXception -> developer exception
        - NULLPTREXCEPTION
        - shouldn't be handled

- deal with exception
    - catch and handle : try , catch , finally
        - try : examine it
        - catch handle exception
        - finally : happens it both cases
    - catch and throw it again
        - method throws XYException
        - who will call it should handle this exception
    - catch and throw another exception

- Error
    - out of memory
    - stack overflow


