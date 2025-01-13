import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = Arrays.copyOf(strArr, strArr.length);
        
        for(int i = 0; i < answer.length; i++) {
            if(i % 2 != 0) {
                answer[i] = answer[i].toUpperCase();
            }
            else {
                answer[i] = answer[i].toLowerCase();
            }
        }
        
        
        return answer;
    }
}