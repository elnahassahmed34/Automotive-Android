# c++

## content
- strings
- vector
- I/O (files)
- manipulator
- Excetions
- lambda functions

### OOP
- Inh + poly
- opr overloading
- smart ptrs
- rule 3 & 5
- casting


## template instintiation
- can't make .h and .cpp for templates
- soultions
    - include .cpp in .h
    - include implemetation in .h
    - explicitly declare the functions
    - export keyword

## strings

### cstyle
```c
char arr[] = "hello"
char * ptr = &arr ;
//strcpy , strlen , strcmp   
// can cause memory leak
```

### c++style
- string is a class

```cpp
std::string var = "hello";
var += "yes" ;

//ptr in stack , data in heap
std::string v = new std::string{"hello"};
delete v ;
```

### comparison c vs c++ strings

string          c-style

class           arr of char

overhead        high performance


| comp | string | cstyle |
|----------|----------|----------|
| imp. | class | arr of char |
| perf. | overhead | high perf. |
| functions | methods | calling functions |

- strings operations
- from string to another (stoi)
- string view