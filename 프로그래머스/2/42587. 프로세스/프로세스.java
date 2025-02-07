import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            pq.offer(priorities[i]);
        }
        
        int order = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(priorities[current] == pq.peek()) {
                order++;
                pq.poll();
                if(current == location) {
                    return order;
                }
            } else {
                queue.offer(current);
            }
        }
        
        return order;
    }
}
