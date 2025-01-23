import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        
        for (int amount : d) {
            if (budget >= amount) {
                budget -= amount;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}