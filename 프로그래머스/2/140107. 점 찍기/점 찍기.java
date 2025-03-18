class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquared = (long) d * d;
        int aMax = d / k;
        
        for(int a = 0; a <= aMax; a++) {
            long x = (long) a * k;
            long remaining = dSquared - x * x;
            
            if(remaining < 0) continue;
            
            long sqrtRemaining = (long) Math.sqrt(remaining);
            long maxB = sqrtRemaining / k;
            answer += maxB + 1;
        }
        
        return answer;
    }
}
