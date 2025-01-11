import java.util.*;

class Solution {
    public ArrayList<String> solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        String[] strArr = myString.split("x");
               
        for(String str : strArr){
            if(!str.isEmpty()){
                answer.add(str);
            }
        }
        
        Collections.sort(answer);  
        
        
        return answer;
    }
}