import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);
        
        return result;
    }
}