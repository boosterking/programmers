import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for(int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];

            boolean[] visited = new boolean[n+1];
            int count = dfs(v1, v2, graph, visited);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }

    private int dfs(int node, int except, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        
        for(int next : graph.get(node)) {
            if(next != except && !visited[next]) {
                count += dfs(next, except, graph, visited);
            }
        }
        
        return count;
    }
}
