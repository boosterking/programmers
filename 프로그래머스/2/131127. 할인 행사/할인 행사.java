import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) wantMap.put(want[i], number[i]);
        
        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> window = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                window.put(discount[j], window.getOrDefault(discount[j], 0) + 1);
            }
            
            if (checkMatch(wantMap, window)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean checkMatch(Map<String, Integer> want, Map<String, Integer> window) {
        for (String key : want.keySet()) {
            if (!window.containsKey(key) || window.get(key) < want.get(key)) {
                return false;
            }
        }
        return true;
    }
}
