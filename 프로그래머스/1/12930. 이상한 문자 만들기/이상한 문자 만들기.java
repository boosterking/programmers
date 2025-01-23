class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int wordIndex = 0;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                wordIndex = 0;
            } 
            else {
                answer.append(wordIndex % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
                wordIndex++;
            }
        }
        return answer.toString();
    }
}