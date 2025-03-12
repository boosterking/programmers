import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            int colIndex = col - 1;
            if(a[colIndex] == b[colIndex]) return b[0] - a[0];
            return a[colIndex] - b[colIndex];
        });
        
        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            int[] row = data[i - 1];
            for(int value : row) s_i += value % i;
            answer ^= s_i;
        }
        
        return answer;
    }
}
