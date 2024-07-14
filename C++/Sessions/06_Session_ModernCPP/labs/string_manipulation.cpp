#include <iostream>
#include <string>

int main(){
    std::string text = "The cycle of life is a cycle of cycles";
    std::cout << text << std::endl;

    // Replace "cycle" with "circle"
    auto position = text.find("cycle");
    //std::cout << position <<std::endl;
    while (position != std::string::npos) {
        text.replace(position, 5, "circle");
        position = text.find("cycle", position + 6); 
        //std::cout << position <<std::endl;
    }
    std::cout << text << std::endl;

    // Insert "great" before the first "circle"
    auto position2 = text.find("circle");
    text.insert(position2, "great "); 
    std::cout << text << std::endl;

    // Insert "never-ending" before the second "circle"
    auto position3 = text.find("circle"); 
    position3 = text.find("circle", position3 + 6); 
    text.insert(position3 , "never-ending "); 
    
    std::cout << text << std::endl;

    return 0;
}
