#include <iostream>
#include <utility> 

using namespace std;

namespace ArrayPair {
    pair<int, int>* createarray(int size) {
        auto arrOfPairs = new pair<int, int>[size]; 
        return arrOfPairs; 
    }

    void deletearray(pair<int, int>* arrOfPairs) {
        delete[] arrOfPairs;
    }

    
    void setpair(pair<int, int>* arrOfPairs, int index, int x, int y) {
        arrOfPairs[index].first = x;
        arrOfPairs[index].second = y;
    }

    pair<int, int> getpair(pair<int, int>* arrOfPairs, int index) {
        return arrOfPairs[index];
    }

    void printarray(pair<int, int>* arrOfPairs, int size) {
        for (int i = 0; i < size; ++i) {
            cout << "(" << arrOfPairs[i].first << ", " << arrOfPairs[i].second << ")" << endl;
        }
    }
}

int main() {
    int size = 3;

    auto arrOfPairs = ArrayPair::createarray(size);

   ArrayPair::setpair(arrOfPairs, 0, 10, 20);
    ArrayPair::setpair(arrOfPairs, 1, 30, 40);
    ArrayPair::setpair(arrOfPairs, 2, 50, 60);

    cout << "Array of pairs:" << endl;
    ArrayPair::printarray(arrOfPairs, size);

     auto p = ArrayPair::getpair(arrOfPairs, 1);
    cout << "Pair at index 1: (" << p.first << ", " << p.second << ")" << endl;

    ArrayPair::deletearray(arrOfPairs);

    return 0;
}
