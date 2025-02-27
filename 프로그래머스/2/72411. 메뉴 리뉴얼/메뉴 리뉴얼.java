import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> courseMenus = new HashMap<>();

        for (int c : course) courseMenus.put(c, new HashMap<>());

        for(String order : orders) {
            int orderBit = 0;
            for(char c : order.toCharArray()) orderBit |= (1 << (c - 'A'));
            
            for(int c : course) generateCombinations(orderBit, 0, 0, c, courseMenus.get(c));
        }

        for(int c : course) {
            Map<Integer, Integer> menus = courseMenus.get(c);
            if(!menus.isEmpty()) {
                int maxCount = Collections.max(menus.values());
                if(maxCount >= 2) {
                    for(Map.Entry<Integer, Integer> entry : menus.entrySet()) {
                        if(entry.getValue() == maxCount) answer.add(bitToString(entry.getKey()));
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void generateCombinations(int orderBit, int start, int current, int remain, Map<Integer, Integer> menus) {
        if(remain == 0) {
            menus.put(current, menus.getOrDefault(current, 0) + 1);
            return;
        }
        
        for(int i = start; i < 26; i++) {
            if((orderBit & (1 << i)) != 0) generateCombinations(orderBit, i + 1, current | (1 << i), remain - 1, menus);
        }
    }

    private String bitToString(int bit) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if((bit & (1 << i)) != 0) sb.append((char) ('A' + i));
        }
        return sb.toString();
    }
}
