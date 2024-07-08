/*
Class // Pair
Create a template class Pair that holds two values of potentially different types. The class should have the following:
-Two private member variables of the template type.
- A constructor that takes two parameters of the template type and initializes the member variables.
* A method getfirst() that returns the first value.
* A method getSecond() that returns the second value.
- A method setFirst() that sets the first value.
- A method setSecond() that sets the second value.
- Swap method that swaps the first and second values.
In the main function, Test your class, and create an array of pairs of different types
*/
#include<iostream>
#include<utility>

using namespace std ;

class Pair_Int{
    
    int first ;
    int second ;
    
public:
    Pair(): first(0) , second(0){
    }
    Pair(int x , int y): first(x) , second(y){       
    }
    int GetFirst(){
        return first ;
    }
    int GetSecond(){
        return second ;
    }
    void SetFirst(int value){
        first = value ;
    }
    void SetSecond(int y){
        second = y ;
    }
    void SetPairs(int x ,int y){
        first = x ;
        second = y ;
    }
    void SwapPairs(void){
        int temp = first ;
        first = second ;
        second = temp ;
    }

};

class Pair_String{
    
    string first ;
    string second ;
    
public:
    Pair(): first(0) , second(0){
    }
    Pair(string x , string y): first(x) , second(y){       
    }
    string GetFirst(){
        return first ;
    }
    string GetSecond(){
        return second ;
    }
    void SetFirst(string value){
        first = value ;
    }
    void SetSecond(string y){
        second = y ;
    }
    void SetPairs(string x ,string y){
        first = x ;
        second = y ;
    }
    void SwapPairs(void){
        string temp = first ;
        first = second ;
        second = temp ;
    }

};


string main(){

    Pair_Int obj ;
    int x = obj.GetFirst();
    cout << x << endl ;

    return 0 ;
}

