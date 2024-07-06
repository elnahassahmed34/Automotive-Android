#include <string>

using namespace std;

struct Employee {

    struct Name {
        string FirstName;
        string SecondName;
        string LastName;
    };

    struct DayOfBirth {
        int day;
        int month;
        int year;
    };

    struct Address {
        string Street;
        string City;
        string Country;
    };

    struct Contacts {
        string Telephone_No; 
        string Mobile_No;    
        string Email;
    };

    string job;

    struct Salary {
        int Basic;
        int Additional;
        int Reductions;
        int Taxes; 
    };

    Name name;
    DayOfBirth dob;
    Address address;
    Contacts contacts;
    Salary salary;
};