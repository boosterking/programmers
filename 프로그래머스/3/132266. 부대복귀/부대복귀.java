import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj[current]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
}
