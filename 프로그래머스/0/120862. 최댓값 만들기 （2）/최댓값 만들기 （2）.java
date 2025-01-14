import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        int n = numbers.length;
        int max1 = numbers[n - 1] * numbers[n - 2]; 
        int max2 = numbers[0] * numbers[1];        
        
        return Math.max(max1, max2);
    }
}