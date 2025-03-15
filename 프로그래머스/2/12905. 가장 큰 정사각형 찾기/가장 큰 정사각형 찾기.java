class Solution {
    public int solution(int[][] board) {
        int rows = board.length;
        if(rows == 0) return 0;
        int cols = board[0].length;
        if(cols == 0) return 0;
        
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                } 
                else if(board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } 
                else {
                    dp[i][j] = 0;
                }
                
                if(dp[i][j] > maxSide) {
                    maxSide = dp[i][j];
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
