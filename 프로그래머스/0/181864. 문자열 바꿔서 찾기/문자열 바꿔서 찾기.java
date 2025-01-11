class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        String rpStr = myString.replace('A', 'T').replace('B', 'A').replace('T', 'B');
        
        if(rpStr.contains(pat)){
            answer = 1;
        }
        return answer;
    }
}