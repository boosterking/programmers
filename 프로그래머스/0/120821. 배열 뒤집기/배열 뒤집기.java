import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length);
        int s = 0, e = num_list.length - 1;
        
        while(s < e) {
            int temp = answer[s];
            answer[s++] = answer[e];
            answer[e--] = temp;
        }
        
        return answer;
    }
}