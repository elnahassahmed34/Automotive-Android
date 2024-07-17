#include <iostream>
#include <cstdlib>  
#include <ctime>    

class Battleship {
private:
    bool board[5][5];
    int guesses;
    int maGuesses;
    int locationX, locationY;

public:
    
    Battleship(int maxGuesses) : maGuesses(maxGuesses), guesses(0) {
    
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                board[i][j] = false;
            }
        }

        srand(static_cast<unsigned>(time(0)));

        locationX = rand() % 5;
        locationY = rand() % 5;
    }

    bool guess(int x, int y) {
        ++guesses;

        if (x == locationX && y == locationY) {
            std::cout << "Hit! You've found the battleship!" << std::endl;
            return true;
        } else {
            std::cout << "Miss! ";

            if (x == locationX) {
                std::cout << "You are in the same row as the battleship." << std::endl;
            } else if (y == locationY) {
                std::cout << "You are in the same column as the battleship." << std::endl;
            } else {
                std::cout << "The battleship is in a different row and column." << std::endl;
            }

            return false;
        }
    }

    bool gameOver() const {
        return guesses >= maGuesses;
    }

    int getGuesses() const {
        return guesses;
    }
};

int main() {
    Battleship game(5);  
    int x, y;

    std::cout << "Welcome to Battleship!" << std::endl;

    while (!game.gameOver()) {
        std::cout << "Enter your guess (row and column): ";
        std::cin >> x >> y;

        if (x < 0 || x >= 5 || y < 0 || y >= 5) {
            std::cout << "Invalid coordinates. Please try again." << std::endl;
            continue;
        }

        bool hit = game.guess(x, y);

        if (hit) {
            std::cout << "Congratulations! You found the battleship in " << game.getGuesses() << " guesses." << std::endl;
            break;
        } else if (game.gameOver()) {
            std::cout << "Game over! You've used all your guesses." << std::endl;
        }
    }

    return 0;
}
