import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        
        int quotient = s / n;
        int remainder = s % n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, quotient);
        
        for(int i = 0; i < remainder; i++) {
            answer[i] += 1;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
