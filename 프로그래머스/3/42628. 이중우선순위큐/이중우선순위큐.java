import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if(command.equals("I")) map.put(value, map.getOrDefault(value, 0) + 1);
            else if (!map.isEmpty()) {
                int key = (value == 1) ? map.lastKey() : map.firstKey();
                int count = map.get(key);
                
                if(count == 1) map.remove(key);
                else map.put(key, count - 1);
            }
        }
        
        return map.isEmpty() ? 
            new int[]{0, 0} : 
            new int[]{map.lastKey(), map.firstKey()};
    }
}
