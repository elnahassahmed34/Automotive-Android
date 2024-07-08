#include <iostream>
#include <string>

enum HTTP_Error {
    Bad_Request = 400,
    Not_Found = 404,
    Server_Error = 500,
    Gate_Error = 504
};

void PrintError(HTTP_Error error) {
    switch (error) {
        case Bad_Request:
            std::cout << "400 Bad Request" << std::endl;
            break;
        case Not_Found:
            std::cout << "404 Not Found" << std::endl;
            break;
        case Server_Error:
            std::cout << "500 Server Error" << std::endl;
            break;
        case Gate_Error:
            std::cout << "504 Gate Error" << std::endl;
            break;
        default:
            std::cout << "Unknown Error" << std::endl;
            break;
    }
}

int main() {
    HTTP_Error obj = Bad_Request;  // Correctly initialize the enum variable
    PrintError(obj);

    obj = Not_Found;
    PrintError(obj);

    obj = Server_Error;
    PrintError(obj);

    obj = Gate_Error;
    PrintError(obj);

    return 0;
}
