import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCount = new HashMap<>();
        
        for (int size : tangerine) {
            sizeCount.put(size, sizeCount.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(sizeCount.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int sum = 0;
        int types = 0;
        
        for (int count : counts) {
            sum += count;
            types++;
            if (sum >= k) break;
        }
        
        return types;
    }
}
