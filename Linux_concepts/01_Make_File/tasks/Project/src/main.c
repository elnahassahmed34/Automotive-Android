#include <stdio.h>
#include "calculator.h"

int main() {
    double a, b;
    char op;

    printf("Enter expression ex:(a + b): ");
    scanf("%lf %c %lf", &a, &op, &b);

    switch (op) {
        case '+':
            printf("Result: %.2lf\n", add(a, b));
            break;
        case '-':
            printf("Result: %.2lf\n", subtract(a, b));
            break;
        case '*':
            printf("Result: %.2lf\n", multiply(a, b));
            break;
        case '/':
            printf("Result: %.2lf\n", divide(a, b));
            break;
        default:
            printf("Unknown operator\n");
    }

    return 0;
}
