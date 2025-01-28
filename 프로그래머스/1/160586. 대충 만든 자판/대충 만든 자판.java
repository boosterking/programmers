import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minPresses = new HashMap<>();
        
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                minPresses.put(c, Math.min(minPresses.getOrDefault(c, i + 1), i + 1));
            }
        }
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            int totalPresses = 0;
            for(char c : targets[i].toCharArray()) {
                if(!minPresses.containsKey(c)) {
                    totalPresses = -1;
                    break;
                }
                totalPresses += minPresses.get(c);
            }
            answer[i] = totalPresses;
        }
        
        return answer;
    }
}