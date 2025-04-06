class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        if(height == 0) return 0;
        
        int[] prevRow = new int[1];
        prevRow[0] = triangle[0][0];
        
        for(int i = 1; i < height; i++) {
            int[] currentRow = new int[i + 1];
            currentRow[0] = prevRow[0] + triangle[i][0];
            currentRow[i] = prevRow[i - 1] + triangle[i][i];
            for(int j = 1; j < i; j++) currentRow[j] = Math.max(prevRow[j - 1], prevRow[j]) + triangle[i][j];
            prevRow = currentRow;
        }
        
        int maxSum = 0;
        for(int num : prevRow) {
            if(num > maxSum) maxSum = num;
        }
        return maxSum;
    }
}
