import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        
        Map<Integer, Integer> lengthCount = new HashMap<>();
        
        for(String str : strArr) {
            str.length();
            lengthCount.put(str.length(), lengthCount.getOrDefault(str.length(), 0) + 1);
        }
        
        int maxCount = 0;
        for (int count : lengthCount.values()) {
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
       
    }
}