import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> student = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]) {
                student.add(i);
            }
        }        
        student.sort((a, b) -> rank[a] - rank[b]);
        
        int a = student.get(0);
        int b = student.get(1);
        int c = student.get(2);
      
        return 10000 * a + 100 * b + c;
    }
}