import java.util.*;

public class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(x);
        visited.add(x);
        
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == y) return steps;
                int[] nextValues = {current + n, current * 2, current * 3};
                
                for (int next : nextValues) {
                    if(next <= y && !visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}
