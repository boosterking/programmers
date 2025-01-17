class Solution {
    public long solution(int balls, int share) {
        long answer = 1;
        
        for(int i = 1; i <= Math.min(share, balls - share); i++) {
            answer = answer * (balls - i + 1) / i;
        }
        
        return answer;
        

    }
}