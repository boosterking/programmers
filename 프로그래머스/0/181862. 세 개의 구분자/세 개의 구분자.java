import java.util.*;

class Solution {
    public ArrayList<String> solution(String myStr) {        
        ArrayList<String> answer = new ArrayList<>();
        
        myStr = myStr.replace("a", " ");
        myStr = myStr.replace("b", " ");
        myStr = myStr.replace("c", " ");
        
        String[] strArr = myStr.split(" ");

        
        for(String str : strArr) {
            if(!str.isEmpty()) {
                answer.add(str);
            }
        }
        if (answer.size()==0) answer.add("EMPTY");
        
        return answer;
    }
}