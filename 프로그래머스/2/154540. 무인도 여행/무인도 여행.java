import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    
    public int[] solution(String[] maps) {
        m = maps.length;
        n = maps[0].length();
        boolean[][] visited = new boolean[m][n];
        List<Integer> islands = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int size = dfs(maps, i, j, visited);
                    islands.add(size);
                }
            }
        }
        
        if(islands.isEmpty()) return new int[]{-1};
        
        Collections.sort(islands);
        return islands.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dfs(String[] maps, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int size = maps[x].charAt(y) - '0';
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                size += dfs(maps, nx, ny, visited);
            }
        }
        
        return size;
    }
}
