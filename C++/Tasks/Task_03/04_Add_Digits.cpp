class Solution {
public:
    int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        
        while (num >= 10) {
            num = helperFunc(num);
        }
        
        return num;
    }

    int helperFunc(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
};