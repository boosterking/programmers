import java.util.*;

class Solution {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> answer = new ArrayList<>();
        
        for(int num : numlist) {
            if(num % n == 0) answer.add(num);
        }
        
        return answer;
    }
}