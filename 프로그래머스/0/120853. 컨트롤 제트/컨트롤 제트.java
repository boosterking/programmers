import java.util.Stack;

class Solution {
    public int solution(String s) {
        String[] tokens = s.split(" ");
        int answer = 0, prev = 0;
        
        for(String token : tokens) {
            int num = token.equals("Z") ? -prev : Integer.parseInt(token);
            answer += num;
            prev = num;
        }
        return answer;
    }
}