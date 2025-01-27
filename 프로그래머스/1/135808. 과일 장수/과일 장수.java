import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int max = 0;
        for (int i = score.length - m; i >= 0; i -= m) {
            max += score[i] * m;
        }
        
        return max;
    }
}