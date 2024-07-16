#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

int main() {

    ofstream out {"test.txt"};

    if(!out){
        cerr << "error openning\n" ; 
        return -1 ;  
    }
    out << "hello nahass";
    out.close();

    ifstream in{"test.txt"};
    if(!in){
        cerr << "error opening to read\n";
        return -1 ;
    } 

    string str ;
    getline(in , str);
    cout << str << endl;
    in.close();

    return 0;
}
