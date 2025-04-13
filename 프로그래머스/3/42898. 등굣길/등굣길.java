class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[m+1][n+1];
        boolean[][] isPuddle = new boolean[m+1][n+1];
    
        for(int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            isPuddle[x][y] = true;
        }
    
        dp[1][1] = 1;
    
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) continue;
                if(isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = (i > 1) ? dp[i-1][j] : 0;
                int left = (j > 1) ? dp[i][j-1] : 0;
                dp[i][j] = (up + left) % MOD;
            }
        }
    
        return dp[m][n] % MOD;
    }
}