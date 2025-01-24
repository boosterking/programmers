import java.util.*;


class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        
        for(int num : nums) {
            unique.add(num);
        }
        
        int types = unique.size();
        int select = nums.length / 2;
        
        return Math.min(types, select);
    }
}