import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
            .boxed()
            .sorted((a, b) -> {
                int diffA = Math.abs(a - n);
                int diffB = Math.abs(b - n);
                return diffA == diffB ? b.compareTo(a) : Integer.compare(diffA, diffB);
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }
}