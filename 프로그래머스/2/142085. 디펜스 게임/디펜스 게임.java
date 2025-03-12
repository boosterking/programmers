import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < enemy.length; i++) {
            minHeap.add(enemy[i]);
            
            if(minHeap.size() > k) {
                int min = minHeap.poll();
                if(n < min) return i;
                n -= min;
            }
        }
        return enemy.length;
    }
}
