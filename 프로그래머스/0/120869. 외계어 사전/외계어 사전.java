import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Set<String> spellSet = new HashSet<>(Arrays.asList(spell));
        
        for(String word : dic) {
            if(word.length() == spell.length) {
                Set<String> wordSet = new HashSet<>();
                
                for(char c : word.toCharArray()) {
                    wordSet.add(String.valueOf(c));
                }
                
                if(wordSet.equals(spellSet)) return 1;
            }
        }
        return 2;
    }
}