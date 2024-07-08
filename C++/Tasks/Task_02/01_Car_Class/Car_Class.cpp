#include <iostream>
#include <string>
#include "Car_Class.h"
/* 
Q1: Write a C++ program to create a class called Car that has private
member variables for company, model, and year. Implement member
functions to get and set these variables
*/

void CAR::SetCompany(std::string c){

    Company = c ;

}
void CAR::Setmodel(std::string M){

    Model = M ;

}
void SetCompany(int y){

    Year = y ;
        
}

std::string CAR::GetCompany(void){

    return Company ;
}
std::string CAR::Getmodel(void){

    return Model ;

}
int CAR::SetCompany(void){

    return Year ;
        
}