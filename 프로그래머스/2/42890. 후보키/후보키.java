import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;
        List<Integer> candidates = new ArrayList<>();

        List<Integer> masks = new ArrayList<>();
        for(int mask = 1; mask < (1 << colCount); mask++) {
            masks.add(mask);
        }
        Collections.sort(masks, (a, b) -> {
            int cntA = Integer.bitCount(a);
            int cntB = Integer.bitCount(b);
            return cntA != cntB ? cntA - cntB : a - b;
        });
        
        for(int mask : masks) {
            Set<String> keys = new HashSet<>();
            boolean isUnique = true;
            for(String[] row : relation) {
                StringBuilder key = new StringBuilder();
                for(int i = 0; i < colCount; i++) {
                    if((mask & (1 << i)) != 0) key.append(row[i]).append(",");
                }
                if(!keys.add(key.toString())) {
                    isUnique = false;
                    break;
                }
            }
            if(!isUnique) continue;

            boolean isMinimal = true;
            for (int candidate : candidates) {
                if((candidate & mask) == candidate) {
                    isMinimal = false;
                    break;
                }
            }
            if(isMinimal) candidates.add(mask);
        }
        
        return candidates.size();
    }
}