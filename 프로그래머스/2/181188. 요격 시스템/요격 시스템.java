import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int lastEnd = 0;
        
        for(int[] target : targets) {
            int s = target[0];
            int e = target[1];
            
            if(s >= lastEnd) {
                count++;
                lastEnd = e;
            }
        }
        
        return count;
    }
}
