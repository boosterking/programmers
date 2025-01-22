class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        int minValue = arr[0];
        for (int num : arr) {
            minValue = Math.min(minValue, num);
        }
        
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for (int num : arr) {
            if (num != minValue) {
                answer[idx++] = num;
            }
        }
        
        return answer;
    }
}