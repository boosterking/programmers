import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(lastSeen.containsKey(c)) {
                answer[i] = i - lastSeen.get(c);
            } 
            else {
                answer[i] = -1;
            }
            lastSeen.put(c, i);
        }
        
        return answer;
    }
}