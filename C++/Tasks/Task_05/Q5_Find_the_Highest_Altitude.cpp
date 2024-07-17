#include <vector>
#include <algorithm> 

class Solution {
public:
    int largestAltitude(std::vector<int>& gain) {
        int altitude = 0;
        int maxAltitude = 0;
        
        for (int i = 0; i < gain.size(); ++i) {
            altitude += gain[i];
            maxAltitude = std::max(maxAltitude, altitude);
        }
        
        return maxAltitude;
    }
};
