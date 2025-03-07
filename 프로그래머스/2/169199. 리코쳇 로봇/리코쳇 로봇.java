import java.util.*;

class Solution {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[][] visited = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Point start = null;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') start = new Point(i, j);
            }
        }
        queue.add(start);
        visited[start.x][start.y] = 1;
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();

            if(board[current.x].charAt(current.y) == 'G') return visited[current.x][current.y] - 1;

            for(int d = 0; d < 4; d++) {
                int nx = current.x;
                int ny = current.y;

                while(true) {
                    int nextX = nx + dx[d];
                    int nextY = ny + dy[d];
                    
                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || board[nextX].charAt(nextY) == 'D') break;
                    
                    nx = nextX;
                    ny = nextY;
                }

                if(visited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[current.x][current.y] + 1;
                }
            }
        }

        return -1;
    }
}
