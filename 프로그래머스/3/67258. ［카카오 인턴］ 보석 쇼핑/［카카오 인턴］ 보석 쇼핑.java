import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
        int totalUnique = uniqueGems.size();
        Map<String, Integer> freqMap = new HashMap<>();
        int currentUnique = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        int left = 0;

        for(int right = 0; right < gems.length; right++) {
            String gem = gems[right];
            freqMap.put(gem, freqMap.getOrDefault(gem, 0) + 1);
            if(freqMap.get(gem) == 1) {
                currentUnique++;
            }

            while(currentUnique == totalUnique) {
                int currentWindow = right - left + 1;
                if(currentWindow < minLen) {
                    minLen = currentWindow;
                    result[0] = left + 1;
                    result[1] = right + 1;
                }

                String leftGem = gems[left];
                freqMap.put(leftGem, freqMap.get(leftGem) - 1);
                if(freqMap.get(leftGem) == 0) {
                    currentUnique--;
                }
                left++;
            }
        }

        return result;
    }
}
