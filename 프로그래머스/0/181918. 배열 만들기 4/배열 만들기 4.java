import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int size = temp.size();
            if(size == 0) {
                temp.add(arr[i]);
                i++;
            }
            else {
                if(temp.get(size - 1) < arr[i]) {
                    temp.add(arr[i]);
                    i++;
                }
                else {
                    temp.remove(size - 1);
                }
            }
        }

        int[] stk = temp.stream().mapToInt(Integer::intValue).toArray();
        return stk;
    }
}