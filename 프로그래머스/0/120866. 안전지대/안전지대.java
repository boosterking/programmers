class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] dangerZone = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    markDangerZone(dangerZone, i, j, board.length, board[0].length);
                }
            }
        }
        
        int safeCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0 && !dangerZone[i][j]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }
    
    private void markDangerZone(boolean[][] dangerZone, int x, int y, int rows, int cols) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int newX = x + dx;
                int newY = y + dy;
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    dangerZone[newX][newY] = true;
                }
            }
        }
    }
}