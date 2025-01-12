class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        if(str2.toLowerCase().contains(str1.toLowerCase())){
            answer = 1;
        }
        
        return answer;
    }
}