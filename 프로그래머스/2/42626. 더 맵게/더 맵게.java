import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        int mixCount = 0;
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            int newScov = first + (second * 2);
            pq.offer(newScov);
            mixCount++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return mixCount;
    }
}