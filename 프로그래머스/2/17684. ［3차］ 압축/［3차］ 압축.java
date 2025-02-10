import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int dictIndex = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), dictIndex++);
        }

        String w = "";
        for(int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            String wc = w + c;

            if(dictionary.containsKey(wc)) {
                w = wc;
            }
            else {
                answer.add(dictionary.get(w));
                dictionary.put(wc, dictIndex++);
                w = String.valueOf(c);
            }
        }

        if(!w.isEmpty()) {
            answer.add(dictionary.get(w));
        }

        return answer;
    }
}

