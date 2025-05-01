import java.util.*;

public class Solution {
    static int[] parent;

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if(find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }
        }

        return answer;
    }
}
