class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long[] merged = new long[n * 2];
        long totalSum = 0;
        long q1Sum = 0;

        if(n == 0) return -1;

        for(int i = 0; i < n; i++) {
            merged[i] = queue1[i];
            merged[n + i] = queue2[i];
            totalSum += queue1[i] + queue2[i];
            q1Sum += queue1[i];
        }

        if(totalSum % 2 != 0) return -1;

        long target = totalSum / 2;
        int left = 0, right = n;
        int count = 0;

        while(count < n * 4) {
            if(q1Sum == target) return count;

            if(left >= n * 2 && right >= n * 2) return -1;

            if(q1Sum > target) {
                q1Sum -= merged[left % (n * 2)];
                left++;
            } 
            else {
                q1Sum += merged[right % (n * 2)];
                right++;
            }
            count++;
        }
        return -1;
    }
}
