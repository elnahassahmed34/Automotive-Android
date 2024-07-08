#include <iostream>
#include <cmath>
#include "Calculator.h"

using namespace std;

void Calculator::calculate() {
    double num1, num2, result;
    char op;

    cout << "Enter first number: ";
    cin >> num1;
    cout << "Enter an operator (+, -, *, /, ^, S for sqrt): ";
    cin >> op;

    switch(op) {
        case '+':
            cout << "Enter second number: ";
            cin >> num2;
            result = add(num1, num2);
            break;
        case '-':
            cout << "Enter second number: ";
            cin >> num2;
            result = subtract(num1, num2);
            break;
        case '*':
            cout << "Enter second number: ";
            cin >> num2;
            result = multiply(num1, num2);
            break;
        case '/':
            cout << "Enter second number: ";
            cin >> num2;
            result = divide(num1, num2);
            break;
        case '^':
            cout << "Enter exponent: ";
            cin >> num2;
            result = power(num1, num2);
            break;
        case 'S':
            result = squareRoot(num1);
            break;
        default:
            cout << "Invalid operator" << endl;
            return;
    }
    cout << "Result: " << result << endl;
}

double Calculator::add(double a, double b) {
    return a + b;
}

double Calculator::subtract(double a, double b) {
    return a - b;
}

double Calculator::multiply(double a, double b) {
    return a * b;
}

double Calculator::divide(double a, double b) {
    if (b == 0) {
        cout << "Error: Division by zero" << endl;
        return 0;
    }
    return a / b;
}

double Calculator::power(double base, double exponent) {
    return pow(base, exponent);
}

double Calculator::squareRoot(double a) {
    if (a < 0) {
        cout << "Error: Negative input for square root" << endl;
        return 0;
    }
    return sqrt(a);
}
