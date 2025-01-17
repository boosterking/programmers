import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        Set<Integer> factors = new HashSet<>();
        
        for(int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>(factors);
        Collections.sort(answer);
        
        return answer;
    }
}