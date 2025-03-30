import java.util.*;

public class Solution {
    private boolean[][] isExternal;

    public int solution(String[] storage, String[] requests) {
        int rows = storage.length;
        int cols = storage[0].length();
        char[][] grid = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            grid[i] = storage[i].toCharArray();
        }

        for(String req : requests) {
            if(req.length() == 2) {
                char target = req.charAt(0);
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if(grid[i][j] == target) grid[i][j] = '.';
                    }
                }
            } 
            else {
                char target = req.charAt(0);
                markExternalAreas(grid);
                boolean[][] toRemove = new boolean[rows][cols];

                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if(grid[i][j] == target && isAdjacentToExternal(i, j)) toRemove[i][j] = true;
                    }
                }

                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if(toRemove[i][j]) grid[i][j] = '.';
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != '.') count++;
            }
        }
        return count;
    }

    private void markExternalAreas(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        isExternal = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && grid[i][j] == '.') {
                    queue.add(new int[]{i, j});
                    isExternal[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                if(ni >= 0 && ni < rows && nj >= 0 && nj < cols && !isExternal[ni][nj] && grid[ni][nj] == '.') {
                    isExternal[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }
    }

    private boolean isAdjacentToExternal(int i, int j) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni < 0 || ni >= isExternal.length || nj < 0 || nj >= isExternal[0].length) return true; // 외부와 직접 연결
            if (isExternal[ni][nj]) return true; 
        }
        return false;
    }
}
