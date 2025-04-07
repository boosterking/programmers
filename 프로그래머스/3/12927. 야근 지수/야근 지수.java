import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long total = 0;
        for(int work : works) {
            total += work;
        }
        if(total <= n) return 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            maxHeap.add(work);
        }
        
        for(int i = 0; i < n; i++) {
            int max = maxHeap.poll();
            maxHeap.add(max - 1);
        }
        
        long answer = 0;
        for(int num : maxHeap) {
            answer += (long) num * num;
        }
        return answer;
    }
}
