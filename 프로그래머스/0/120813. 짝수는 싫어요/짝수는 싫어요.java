import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            if(i % 2 == 1) answer.add(i);
        }
        
        return answer;
    }
}