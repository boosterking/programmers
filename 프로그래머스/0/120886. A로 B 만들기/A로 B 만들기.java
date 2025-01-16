import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        if (before.length() != after.length()) {
            return 0;
        }
        
        char[] bc = before.toCharArray();
        char[] ac = after.toCharArray();
        
        Arrays.sort(bc);
        Arrays.sort(ac);
        
        return Arrays.equals(bc, ac) ? 1 : 0;
    }
}