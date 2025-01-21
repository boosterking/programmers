import java.util.*;

class Solution {
    public long solution(long n) {
        String s = Long.toString(n);
        
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder(arr.length);
        for (Character c : arr) {
            sb.append(c);
        }
        
        return Long.parseLong(sb.toString());
    }
}