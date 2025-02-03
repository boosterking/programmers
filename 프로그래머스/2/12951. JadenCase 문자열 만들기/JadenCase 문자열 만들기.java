class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isNewWord = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                isNewWord = true;
            } else if (isNewWord) {
                answer.append(Character.toUpperCase(c));
                isNewWord = false;
            } else {
                answer.append(Character.toLowerCase(c));
            }
        }
        
        return answer.toString();
    }
}

