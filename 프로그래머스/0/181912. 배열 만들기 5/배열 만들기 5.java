import java.util.*;

class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while (i < intStrs.length) {
            char[] arr = intStrs[i].toCharArray();
            String value = "";
            for(int j = s; j <= s + l - 1; j++) {
                value += arr[j];               
            }
            if(Integer.parseInt(value) > k) {
                answer.add(Integer.parseInt(value));
            }
            i++;
        }           
        
        return answer;
    }
}