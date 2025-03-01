import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        
        for(int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], distance = cur[1];
            
            if(distance > dist[node]) continue;
            
            for(int i = 1; i <= N; i++) {
                if(graph[node][i] != Integer.MAX_VALUE) {
                    int newDist = distance + graph[node][i];
                    if(newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.offer(new int[]{i, newDist});
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) count++;
        }
        
        return count;
    }
}
