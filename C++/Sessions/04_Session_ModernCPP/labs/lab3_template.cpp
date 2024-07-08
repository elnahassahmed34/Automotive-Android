#include <iostream>
#include <utility>
#include <algorithm>

using namespace std;

template <typename T, typename U>
class Pair {
    T first;
    U second;

public:
    Pair() : first(), second() {}

    Pair(T x, U y) : first(x), second(y) {}

    T GetFirst() const {
        return first;
    }

    U GetSecond() const {
        return second;
    }

    void SetFirst(T value) {
        first = value;
    }

    void SetSecond(U value) {
        second = value;
    }

    // void SwapPairs() {
    //     swap(first, second);
    // }
};

template<> 
class Pair<string, char>{};

int main() {
    Pair<int, double> pair1(10, 3.14);
    Pair<string, char> pair2("Hello", 'C');

    cout << "Pair 1: " << pair1.GetFirst() << ", " << pair1.GetSecond() << endl;
    pair1.SetFirst(20);
    //pair1.SwapPairs();
    cout << "Pair 1 after modification: " << pair1.GetFirst() << ", " << pair1.GetSecond() << endl;

    cout << "Pair 2: " << pair2.GetFirst() << ", " << pair2.GetSecond() << endl;
    pair2.SetSecond('D');
    cout << "Pair 2 after modification: " << pair2.GetFirst() << ", " << pair2.GetSecond() << endl;

    return 0;
}
