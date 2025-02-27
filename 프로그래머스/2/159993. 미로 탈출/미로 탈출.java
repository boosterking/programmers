import java.util.ArrayDeque;

class Solution {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static final int INF = 10000;

    public int solution(String[] maps) {
        int n = maps.length, m = maps[0].length();
        int start = -1, lever = -1, exit = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int pos = i * m + j;
                char c = maps[i].charAt(j);
                
                if (c == 'S') start = pos;
                else if (c == 'L') lever = pos;
                else if (c == 'E') exit = pos;
            }
        }

        int toLever = bfs(maps, start, lever);
        if(toLever == INF) return -1;

        int toExit = bfs(maps, lever, exit);
        if(toExit == INF) return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, int start, int target) {
        int n = maps.length, m = maps[0].length();
        int[] dist = new int[n * m];
        java.util.Arrays.fill(dist, INF);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == target) return dist[curr];

            int x = curr / m, y = curr % m;
            for(int i = 0; i < 4; i++) {
                int nx = x + DX[i], ny = y + DY[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X') continue;
                
                int next = nx * m + ny;
                if(dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        return INF;
    }
}
