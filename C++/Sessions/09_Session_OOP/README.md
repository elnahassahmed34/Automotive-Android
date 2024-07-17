# OOP in c++

## temporary object
```cpp

void function(Example &&e){} //valid
void function(Example e){} //valid
void function(const Example &e){} //valid
void function(Example &e){} //not valid excepect l value

int main(){

    function(EXample());
    return 0 ;
}
```

## RVO concept : neglect cons and dest of the object

## friend class and function

## priority for initilization: A a{1,3};

- initializer list A{std::initializer_list}
- paramatrized cons A(int x , int y)
- substitute normal as constructor {private: int a ,b } 
 
- but A a(1,3) will search for paramatrized const.

## delete and const 

## Inheritance
- Single
- multiple
- multilevel
- hybird

## Design
- think about comman and unique properties
- Inh  : is a relationsship
- comp : has a relationship 
- Aggregations : class A{} classB{A * a;}

## privacy specifiers
- public
- protected
- protected




