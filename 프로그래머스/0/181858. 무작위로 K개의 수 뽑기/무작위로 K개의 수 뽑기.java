import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> numbers = new HashSet<>();
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        int idx = 0;
        for (int num : arr) {
            if (numbers.add(num)) {
                answer[idx++] = num;
                if (idx == k) {
                    break;
                }
            }
        }
        
        return answer;
    }
}