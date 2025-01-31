import java.util.*;
import java.time.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        LocalDate todayDate = LocalDate.parse(today.replace(".", "-"));
        
        for(String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            LocalDate collectionDate = LocalDate.parse(parts[0].replace(".", "-"));
            String termType = parts[1];
            
            LocalDate expirationDate = collectionDate.plusMonths(termMap.get(termType)).minusDays(1);
            if(todayDate.isAfter(expirationDate)){
                answer.add(i + 1);
            }
        }
        return answer;
    }
}