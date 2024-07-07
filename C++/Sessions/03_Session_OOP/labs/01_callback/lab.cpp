#include <iostream>

class Example {
public:
    static int staticVar; // Static variable declaration

    void nonStaticFunction() {
        // Accessing and modifying the static variable
        staticVar++;
        std::cout << "Static variable value: " << staticVar << std::endl;
    }
};

// Static variable definition and initialization
int Example::staticVar = 0;

int main() {
    Example obj1, obj2;

    obj1.nonStaticFunction(); // Output: Static variable value: 1
    obj2.nonStaticFunction(); // Output: Static variable value: 2

    return 0;
}
