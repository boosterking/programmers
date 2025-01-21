import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                answer.add(num);
            }
        }
        
        if (answer.isEmpty()) {
            answer.add(-1);
        } else {
            Collections.sort(answer);
        }
        
        return answer;
    }
}