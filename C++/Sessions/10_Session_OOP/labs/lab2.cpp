#include <iostream>

using namespace std ;

void function(int a){
    cout << "normal" << endl;
}
void function2(int& a){
    cout << "medium" << endl;
}
void function2(const int& a){
    cout << "high" << endl;
}
void function2(int&& a){
    cout << "prvalue" << endl;
}


class example{
public:
    int var ;
    int xar ;

    example() = default ;
    example(int var , int xar): var(var) , xar(xar)
    {}
    //copy constructor
    example(int const &obj){
        cout << "copy" << endl;
    }
    //move constructor
    example(example &&obj){
        cout << "move" << endl;
        var = obj.var ;
        xar = obj.xar ;
    }

};

void function2(example &&obj);

int main(){

    
    function2(example(1,2));

    int x = 10 ;
    const int y = 11;
    
     //-> -> create temp and make var point to it
    int &&var = 5+2+x ;

    
    
    function2(10); //prvalue int && a
    function2(x); //medium int& a
    function2(y); //high const int &a
    function2(var); //medium int &a



    

    return 0 ;

}