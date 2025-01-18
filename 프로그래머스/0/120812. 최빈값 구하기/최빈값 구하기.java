import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int mode = 0;
        
        for (int num : array) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            
            if (count > maxCount) {
                maxCount = count;
                mode = num;
            }
        }
        
        int modeCount = 0;
        for (int count : countMap.values()) {
            if (count == maxCount) {
                modeCount++;
            }
        }
        
        return modeCount > 1 ? -1 : mode;
    }
}