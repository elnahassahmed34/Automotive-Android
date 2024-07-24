#include <iostream>

class Example {
public:
    int var;
    int xar;
    int arr[5]{1,2,3,4,5};

    // Constructor
    Example(int x, int y) : var(x), xar(y) {}

    // Method to add two Example objects
    Example add(const Example& obj) const {
        return Example(obj.var + this->var, obj.xar + this->xar);
    }

    // Operator+ overload to add two Example objects
    Example operator+(const Example& obj) const {
        return Example(obj.var + this->var, obj.xar + this->xar);
    }

    Example operator!(){
        return example(-1 * var , -1 * xar);
    }

    int operator[](int pos) const{
        return arr[pos];
    }

    ~Example(){
        std::cout << "destructor" << std::endl;
    }

    //++x
    Example& operator++(){
        ++var , ++xar ;
        return *this;
    }
    
    //x++
    Example operator++(int){
        Example temp = *this ;
        ++var , ++xar ;
        return temp;
    }
    
    void print() const{
        std::cout << "my var =" << var << std::endl;
        std::cout << "my xar =" << xar << std::endl;
    }
};

// Global function to overload the + operator for Example and int
Example operator+(const Example& obj, int x) {
    return Example(obj.var + x, obj.xar + x);
}

int main() {
    Example obj1(1, 2);
    Example obj2(2, 2);

    // Using add method
    Example sum1 = obj1.add(obj2);
    std::cout << "sum1: " << sum1.var << ", " << sum1.xar << std::endl;

    // Using operator+ method directly
    Example sum2 = obj1.operator+(obj2);
    std::cout << "sum2: " << sum2.var << ", " << sum2.xar << std::endl;

    // Using overloaded + operator
    Example sum3 = obj1 + obj2;
    std::cout << "sum3: " << sum3.var << ", " << sum3.xar << std::endl;

    // Using overloaded + operator with int
    Example sum4 = obj1 + 5;
    std::cout << "sum4: " << sum4.var << ", " << sum4.xar << std::endl;

    Example sum5 = !obj1 + obj2 ;

    int x = sum5[1];

    

    // int x = 6 ;
    // //Lvalue x = x+1
    // x++ ;

    // // print then increment
    // ++x ;

    Example prefix(1,2);
    (++prefix).print();
    (prefix++).print();

    return 0;
}
