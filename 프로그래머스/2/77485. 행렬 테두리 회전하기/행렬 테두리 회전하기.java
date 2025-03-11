import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            List<Integer> elements = new ArrayList<>();

            for(int y = y1; y <= y2; y++) {
                elements.add(matrix[x1][y]);
            }
            for(int x = x1 + 1; x <= x2; x++) {
                elements.add(matrix[x][y2]);
            }
            if(x1 < x2) {
                for(int y = y2 - 1; y >= y1; y--) {
                    elements.add(matrix[x2][y]);
                }
            }
            if(y1 < y2) {
                for(int x = x2 - 1; x > x1; x--) {
                    elements.add(matrix[x][y1]);
                }
            }

            int min = Collections.min(elements);
            result.add(min);

            if(!elements.isEmpty()) {
                int last = elements.remove(elements.size() - 1);
                elements.add(0, last);
            }

            int index = 0;

            for(int y = y1; y <= y2; y++) {
                matrix[x1][y] = elements.get(index++);
            }
            for(int x = x1 + 1; x <= x2; x++) {
                matrix[x][y2] = elements.get(index++);
            }
            if(x1 < x2) {
                for(int y = y2 - 1; y >= y1; y--) {
                    matrix[x2][y] = elements.get(index++);
                }
            }

            if(y1 < y2) {
                for(int x = x2 - 1; x > x1; x--) {
                    matrix[x][y1] = elements.get(index++);
                }
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
