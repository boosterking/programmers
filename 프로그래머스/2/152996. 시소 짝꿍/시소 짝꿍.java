import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = 0; i < weights.length; i++) {
            double w = weights[i];
            answer += map.getOrDefault(w, 0);
            
            map.put(w, map.getOrDefault(w, 0) + 1);
            map.put(w*4/3, map.getOrDefault(w*4/3, 0) + 1);
            map.put(w*3/2, map.getOrDefault(w*3/2, 0) + 1);
            map.put(w*2, map.getOrDefault(w*2, 0) + 1);
        }
        
        return answer;
    }
}
