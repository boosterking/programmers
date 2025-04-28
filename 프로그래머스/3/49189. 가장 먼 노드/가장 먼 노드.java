import java.util.*;

public class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph.get(current)) {
                if(distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int maxDistance = Arrays.stream(distance).max().getAsInt();
        int count = 0;
        for(int d : distance) {
            if(d == maxDistance) count++;
        }

        return count;
    }
}
