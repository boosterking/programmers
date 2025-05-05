class Solution {
    public long solution(int[] sequence) {
        long maxSum1 = Long.MIN_VALUE;
        long maxSum2 = Long.MIN_VALUE;
        long currentSum1 = 0;
        long currentSum2 = 0;
        
        for(int i = 0; i < sequence.length; i++) {
            int t1 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            int t2 = (i % 2 == 0) ? -sequence[i] : sequence[i];
            
            currentSum1 = Math.max(t1, currentSum1 + t1);
            currentSum2 = Math.max(t2, currentSum2 + t2);
            
            maxSum1 = Math.max(maxSum1, currentSum1);
            maxSum2 = Math.max(maxSum2, currentSum2);
        }
        
        return Math.max(maxSum1, maxSum2);
    }
}
