import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for(int[] a : answer) {
            Arrays.fill(a, 0);
        }
        
        
        for(int i = 0; i < n; i ++) {
            answer[i][i] = 1;
        }
        
        return answer;
    }
}