#include <iostream>

using namespace std ;

int main(){

    int input ;
    int result = 0 ;
    cout << "Please Enter the time in Seconds : " << endl;
    cin >> input ;

    int constant = 60 * 60 ;

    int Hours = input / constant ;
    int Reminder = input % constant ;
    int Minuts = Reminder / 60 ;
    int Seconds = Minuts % 60 ;


    cout << "H:M:S - " << Hours << ":" << Minuts << ":" << Seconds << endl;

    return 0 ;

}