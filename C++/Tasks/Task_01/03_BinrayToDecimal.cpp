#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// Convert binary to decimal
int BinaryToDecimal(vector<int> vec) {
    int decimal = 0;
    for (int i = 0; i < 4; i++) {
        decimal += (vec[i] * pow(2, 3 - i)); // Corrected the power calculation
    }
    return decimal;
}

// Convert decimal to binary
vector<int> DecimalToBinary(int num) {
    vector<int> vec(4, 0);
    for (int i = 3; i >= 0 && num > 0; i--) {
        vec[i] = num % 2;
        num /= 2;
    }
    return vec;
}

int main() {
    char input;
    int result = 0;
    cout << "Binary To Decimal Press B" << endl;
    cout << "Decimal To Binary Press D" << endl;
    vector<int> BinaryValue(4, 0); // Initialize with size 4 and all elements 0
    int DecimalValue;

    cin >> input;
    if (input == 'D') {
        cout << "Enter a decimal number: ";
        cin >> DecimalValue;
        BinaryValue = DecimalToBinary(DecimalValue);
        cout << "Binary No is: ";
        for (int i = 0; i < 4; i++) {
            cout << BinaryValue[i];
        }
        cout << endl;
    }
    if (input == 'B') {
        cout << "Enter 4 binary digits: ";
        for (int i = 0; i < 4; i++) {
            cout << "Enter digit " << i << ": ";
            cin >> BinaryValue[i];
        }
        DecimalValue = BinaryToDecimal(BinaryValue);
        cout << "Decimal No is: " << DecimalValue << endl;
    }
    return 0;
}
