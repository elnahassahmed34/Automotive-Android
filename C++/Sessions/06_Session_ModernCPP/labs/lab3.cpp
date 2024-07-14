#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> transposeVec(const vector<vector<int>>& vec) {
    
    int rows = vec.size();
    int cols = vec[0].size();

    vector<vector<int>> result(cols, vector<int>(rows));

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            result[j][i] = vec[i][j];
        }
    }

    return result;
}

void printVec(const vector<vector<int>>& vec) {
    for (auto v1 : vec) {
        for (auto v2 : v1) {
            cout << v2 << " ";
        }
        cout << endl;
    }    
}

vector<vector<int>> transposeVec2(const vector<vector<int>>& vec) {
    int rows = vec.size();
    int cols = vec[0].size();
    vector<vector<int>> result(cols); 

    for (auto row : vec) {
        int j = 0;
        for (auto elem : row) {
            result[j].push_back(elem); // push back first row , then it will push back others
            j++;
        }
    }
    return result;
}

int main() {
    vector<vector<int>> vec{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    printVec(vec);

    vector<vector<int>> result = transposeVec2(vec);

    printVec(result);

    return 0;
}
