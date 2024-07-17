#include <iostream>

using namespace std ;

int main(){

    int y ;
    auto func = [&y](int x){
        cout << x << endl ;
    };

    func(10);

    return 0 ;
}