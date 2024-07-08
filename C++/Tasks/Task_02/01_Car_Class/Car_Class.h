#include <iostream>
#include <string>


/* 
Q1: Write a C++ program to create a class called Car that has private
member variables for company, model, and year. Implement member
functions to get and set these variables
*/

class CAR{
private:
    std::string Company ;
    std::string Model ;
    int Year ;

public:
    void SetCompany(string c);
    void Setmodel(string M);
    void SetCompany(int y);
    
    std::string GetCompany(void);
    std::string Getmodel(void);
    int GetCompany(void);
    
};

