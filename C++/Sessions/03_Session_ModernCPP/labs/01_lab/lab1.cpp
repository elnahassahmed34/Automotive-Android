#include <cmath>
#include <iostream>
#include <vector>
#include <algorithm> 

using namespace std;

namespace MathFunctions {
    void print(double num) {
        cout << "The square root of " << num << " is " << sqrt(num) << endl;
    }
}

namespace StringFunctions {
    void print(char letter) {
        if (isupper(letter)) {
            cout << "The lower case of " << letter << " is " << static_cast<char>(tolower(letter)) << endl;
        } else {
            cout << "The upper case of " << letter << " is " << static_cast<char>(toupper(letter)) << endl;
        }
    }
}

namespace ArrayFunctions {
    void print(vector<int>& vec) {
        reverse(vec.begin(), vec.end());
        for (int v : vec) {
            cout << v << endl;
        }
    }
}

int main() {
    MathFunctions::print(20.2);

    StringFunctions::print('c');
    
    vector<int> vec = {1, 2, 3};
    ArrayFunctions::print(vec);

    return 0;
}
