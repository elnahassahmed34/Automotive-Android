#ifndef CALCULATOR_H
#define CALCULATOR_H

class Calculator {
public:
    void calculate();
    
private:
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
    double power(double base, double exponent);
    double squareRoot(double a);
};

#endif 
