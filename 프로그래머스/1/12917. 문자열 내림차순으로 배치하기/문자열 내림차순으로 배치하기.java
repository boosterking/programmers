import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] charArray = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        Arrays.sort(charArray, Collections.reverseOrder());

        return new String(Arrays.stream(charArray).map(String::valueOf).reduce("", String::concat));
    }
}