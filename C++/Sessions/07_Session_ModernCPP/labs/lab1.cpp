#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int value = 5;
    int newValue = value * 100;

    const int width = 10;

    cout << "|" << setw(width) << setfill('*') << right << value << "|" << endl;

    cout << "|" << setw(width) << setfill('*') << right << newValue << "|" << endl;

    return 0;
}
