#include <iostream>
#include <iomanip>

class Time {
private:
    int hours;
    int minutes;
    int seconds;

public:
   
     Time() : hours(0), minutes(0), seconds(0) {}

    Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {}

    void display() const {
        std::cout << std::setw(2) << std::setfill('0') << hours << ":"
                  << std::setw(2) << std::setfill('0') << minutes << ":"
                  << std::setw(2) << std::setfill('0') << seconds << std::endl;
    }

    void add(const Time& t1, const Time& t2) {
        seconds = t1.seconds + t2.seconds;
        minutes = t1.minutes + t2.minutes + seconds / 60;
        hours = t1.hours + t2.hours + minutes / 60;
        seconds %= 60;
        minutes %= 60;
    }
};

int main() {
   
    const Time t1(5, 30, 15);
    const Time t2(4, 45, 50);

    Time t3;

    t3.add(t1, t2);

    t3.display();

    return 0;
}
