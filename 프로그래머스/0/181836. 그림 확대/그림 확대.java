import java.util.*;

class Solution {
    public List<String> solution(String[] picture, int k) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < picture.length; i++) {
                String[] enlarge = picture[i].split("");
                String str = "";
                for (int j = 0; j < enlarge.length; j++) {
                    str += enlarge[j].repeat(k);
                }
                for (int j = 0; j < k; j++) {
                    answer.add(str);
                }
            }
            return answer;
        }   
}