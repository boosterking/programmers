import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> columnIndex = new HashMap<>();
        columnIndex.put("code", 0);
        columnIndex.put("date", 1);
        columnIndex.put("maximum", 2);
        columnIndex.put("remain", 3);
        
        List<int[]> filteredData = new ArrayList<>();
        for(int[] row : data) {
            if(row[columnIndex.get(ext)] < val_ext) {
                filteredData.add(row);
            }
        }
        
        int sortIndex = columnIndex.get(sort_by);
        Collections.sort(filteredData, (a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));
        
        return filteredData.toArray(new int[filteredData.size()][]);
    }
}