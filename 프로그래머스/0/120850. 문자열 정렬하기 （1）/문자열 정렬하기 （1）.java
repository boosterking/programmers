import java.util.*;

class Solution {
    public List<Integer> solution(String my_string) {
        
        String numbers = my_string.replaceAll("[a-z]", "");
        List<Integer> answer = new ArrayList<>();
        
        for(char c : numbers.toCharArray()) {
            answer.add(Integer.parseInt(String.valueOf(c)));
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}