import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n + 1]; 
        List<Integer> cycleSizes = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                int current = i;
                int count = 0;

                while(!visited[current]) {
                    visited[current] = true;
                    current = cards[current - 1];
                    count++;
                }
                cycleSizes.add(count);
            }
        }

        Collections.sort(cycleSizes, Collections.reverseOrder());

        if(cycleSizes.size() < 2) return 0;
        else return cycleSizes.get(0) * cycleSizes.get(1);
    }
}
