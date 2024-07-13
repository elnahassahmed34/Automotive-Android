#include <iostream>
#include <cstdlib> 
#include <ctime>   

struct Vertex {
    int x;
    int y;
};

int generateRandomNumber() {
    return rand() % 201 - 100;
}

int main() {

    srand(time(0));

    Vertex vertices[5];
    for (int i = 0; i < 5; ++i) {
        vertices[i].x = generateRandomNumber();
        vertices[i].y = generateRandomNumber();
    }

    for (int i = 0; i < 5; ++i) {
        std::cout << "Vertex " << i + 1 << ": (" << vertices[i].x << ", " << vertices[i].y << ")" << std::endl;
    }

    return 0;
}
