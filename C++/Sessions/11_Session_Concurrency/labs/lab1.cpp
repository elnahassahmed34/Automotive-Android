#include <iostream>
#include <thread>
#include <chrono>

void function(int delay) {
    while (true) {
        std::this_thread::sleep_for(std::chrono::seconds(delay));
        std::cout << "\a"; 
    }
}

int main() {
    std::thread obj(function, 3); 

    std::cout << "Press Enter to stop beeping..." << std::endl;
    std::cin.get(); 

   
    beeper.detach();
    return 0;
}
