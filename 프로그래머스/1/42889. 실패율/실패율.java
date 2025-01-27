import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> failRates = new HashMap<>();
        int player = stages.length;
        
        for(int i = 1; i <= N; i++) {
            int count = 0;
            for(int stage : stages) {
                if (stage == i) count++;
            }
            double failRate = (player == 0) ? 0 : (double)count / player;
            failRates.put(i, failRate);
            player -= count;
        }
        return failRates.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();   
    }
}