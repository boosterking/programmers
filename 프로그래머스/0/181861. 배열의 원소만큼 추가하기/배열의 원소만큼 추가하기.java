import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int a : arr) {
            for(int i = 0; i < a; i++) {
                answer.add(a);
            }
        }
              
        return answer;
    }
}