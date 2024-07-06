#include <iostream>

using namespace std;

#define CURRENT_POP 162100
#define MAX_POP     1000000

void Greater(double num, int* times) {
    if (num > MAX_POP) {
        return;
    } else {
        num *= 1 + (6.5 / 100); 
        (*times)++; 
        Greater(num, times);
    }
}

int main() {
    double population = CURRENT_POP;
    int times = 0; 
    Greater(population, &times);

    cout << "It will take " << times << " years for the population to surpass one million." << endl;

    return 0;
}
