public class Solution {
    static boolean[] rowCheck;
    static boolean[] diag1;
    static boolean[] diag2;
    static int count;

    public static int solution(int n) {
        rowCheck = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        count = 0;

        backtrack(0, n);
        return count;
    }

    private static void backtrack(int col, int n) {
        if(col == n) {
            count++;
            return;
        }

        for(int row = 0; row < n; row++) {
            int d1 = col + row;
            int d2 = col - row + n - 1;
            if (rowCheck[row] || diag1[d1] || diag2[d2]) continue;

            rowCheck[row] = diag1[d1] = diag2[d2] = true;
            backtrack(col + 1, n);
            rowCheck[row] = diag1[d1] = diag2[d2] = false;
        }
    }
}
