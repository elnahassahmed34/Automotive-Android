#include <iostream>

using namespace std ;

int main(){

    int input ;
    int result = 0 ;
    cout << "Please Enter a number" << endl;
    cin >> input ;

    while(1){

        if(input == 0){
            cout << "last sum : " << result << endl; ;
            break ;
        }
        else{
            result += input ;
            cout << "the sum is" << result << endl;
            cout << "enter a new number :" << endl;
            cin >> input ;
        }
        

    }

    return 0 ;
}