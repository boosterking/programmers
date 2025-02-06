import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int daysLeft = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.offer(daysLeft);
        }
        
        while(!q.isEmpty()) {
            int day = q.poll();
            int count = 1;

            while(!q.isEmpty() && q.peek() <= day) {
                q.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer;
    }
}
