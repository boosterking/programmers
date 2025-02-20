class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;
        int x = 0, y = 0;
    
        for(int i = 0; i < n; i++) {
            switch(i % 3) {
                case 0:
                    for(int j = i; j < n; j++) {
                        triangle[y++][x] = value++;
                    }
                    y--;
                    x++;
                    break;
                case 1:
                    for(int j = i; j < n; j++) {
                        triangle[y][x++] = value++;
                    }
                    x -= 2;
                    y--;
                    break;
                case 2:
                    for(int j = i; j < n; j++) {
                        triangle[y--][x--] = value++;
                    }
                    y += 2;
                    x++;
                    break;
            }
        }
    
        int[] answer = new int[(n * (n + 1)) / 2];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
    
        return answer;
    }
}