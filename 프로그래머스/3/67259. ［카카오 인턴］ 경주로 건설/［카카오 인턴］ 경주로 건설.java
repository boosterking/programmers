import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int d = 0; d < 4; d++) {
            int nx = dirs[d][0];
            int ny = dirs[d][1];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {
                cost[nx][ny][d] = 100;
                pq.add(new int[]{100, nx, ny, d});
            }
        }
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int x = current[1];
            int y = current[2];
            int dir = current[3];
            
            if(x == N - 1 && y == N - 1) return currentCost;
            
            if(currentCost > cost[x][y][dir]) continue;
            
            for(int d = 0; d < 4; d++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] != 0) continue;
                
                int newCost = currentCost + 100 + (d == dir ? 0 : 500);
                if(newCost < cost[nx][ny][d]) {
                    cost[nx][ny][d] = newCost;
                    pq.add(new int[]{newCost, nx, ny, d});
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int d = 0; d < 4; d++) {
            if(cost[N-1][N-1][d] < minCost) minCost = cost[N - 1][N - 1][d];
        }
        return minCost;
    }
}
