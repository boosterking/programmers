import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        String lastWord = "";
        
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            
            if (i > 0 && (lastWord.charAt(lastWord.length() - 1) != currentWord.charAt(0) || usedWords.contains(currentWord))) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            usedWords.add(currentWord);
            lastWord = currentWord;
        }

        return new int[]{0, 0};
    }
}