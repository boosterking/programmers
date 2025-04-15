public class Solution {
    public int solution(int N, int[] stations, int W) {
        int required = 0;
        int prevEnd = 0;
        int coverage = 2 * W + 1;
        
        for(int s : stations) {
            int start = Math.max(1, s - W);
            int end = Math.min(N, s + W);
            
            if(start > prevEnd + 1) {
                int gapLength = start - (prevEnd + 1);
                required += (gapLength + coverage - 1) / coverage;
            }
            prevEnd = Math.max(prevEnd, end);
        }
        
        if(prevEnd < N) {
            int gapLength = N - prevEnd;
            required += (gapLength + coverage - 1) / coverage;
        }
        
        return required;
    }
}
