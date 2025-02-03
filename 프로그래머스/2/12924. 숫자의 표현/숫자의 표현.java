class Solution {
    public int solution(int n) {
        int count = 0;
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            int current = start;
            while (sum < n) {
                sum += current;
                current++;
            }
            if (sum == n) {
                count++;
            }
        }
        return count;
    }
}