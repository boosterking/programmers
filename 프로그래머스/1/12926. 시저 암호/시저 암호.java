class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                answer.append((char)((c - base + n) % 26 + base));
            }
            else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}