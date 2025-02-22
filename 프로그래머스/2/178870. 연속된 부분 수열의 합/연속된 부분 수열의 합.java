class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(right < sequence.length) {
            sum += sequence[right];

            while(sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }

            if(sum == k) {
                int currentLength = right - left + 1;
                if(currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            right++;
        }

        return answer;
    }
}
