import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("\\},\\{");
        
        Arrays.sort(sets, (a, b) -> a.length() - b.length());

        Set<Integer> answerSet = new LinkedHashSet<>();

        for (String set : sets) {
            for (String num : set.split(",")) {
                answerSet.add(Integer.parseInt(num));
            }
        }

        return answerSet.stream().mapToInt(Integer::intValue).toArray();
    }
}