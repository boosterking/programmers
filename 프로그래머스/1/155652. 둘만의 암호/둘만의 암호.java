class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            char ch = c;
            int count = 0;
            
            while(count < index) {
                ch = (char)((ch - 'a' + 1) % 26 + 'a');
                if(skip.indexOf(ch) == -1) {
                    count++;
                }
            }
            answer.append(ch);
        }
        return answer.toString();
    }
}