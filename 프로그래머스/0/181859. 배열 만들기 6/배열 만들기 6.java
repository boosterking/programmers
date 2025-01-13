import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        for (int num : arr) {
            if (!stk.isEmpty() && stk.get(stk.size() - 1) == num) {
                stk.remove(stk.size() - 1);
            } else {
                stk.add(num);
            }
        }
        
        if (stk.isEmpty()) {
            stk.add(-1);
        }
        
        return stk;
    }
}
