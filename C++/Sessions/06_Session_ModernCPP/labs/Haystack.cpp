#include <iostream>
#include <string>

using namespace std;

string SearchReplace(string &haystack,  string &needle,  string &replacement);

int main() {

    string haystack;
    string needle;
    string replacement;

    cout << "Enter a source string: " << endl;
    getline(cin, haystack); 

    cout << "Enter a string to find: " << endl;
    getline(cin, needle); 

    cout << "Enter a replacement: " << endl;
    getline(cin, replacement); 

    string output = SearchReplace(haystack, needle, replacement);

    cout << "Modified string: " << output << endl;

    return 0;
}

string SearchReplace(string &haystack,  string &needle,  string &replacement) {
    size_t size = needle.size();
    auto position = haystack.find(needle);
    while (position != string::npos) {
        haystack.replace(position, size, replacement);
        position = haystack.find(needle, position + replacement.size()); 
    }
    return haystack;
}
