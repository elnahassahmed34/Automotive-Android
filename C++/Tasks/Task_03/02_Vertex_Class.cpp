#include <iostream>
#include <cstdlib>
#include <ctime>  
#include <string> 

class Vertex {
private:
    int x;
    int y;

public:
    Vertex() {
        setRandomValues();
    }

    void setRandomValues() {
        x = generateRandomNumber();
        y = generateRandomNumber();
    }

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

    std::string toString() const {
        return "(" + std::to_string(x) + ", " + std::to_string(y) + ")";
    }

private:
    int generateRandomNumber() const {
        return rand() % 201 - 100;
    }
};

int main() {
    srand(time(0));

    Vertex vertices[5];
    
    for (int i = 0; i < 5; ++i) {
        std::cout << "Vertex " << i + 1 << ": " << vertices[i].toString() << std::endl;
    }

    return 0;
}
