import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        
        StringBuilder result = new StringBuilder();
        for(String str : strNumbers) {
            result.append(str);
        }
        
        if(result.charAt(0) == '0') {
            return "0";
        }
        
        return result.toString();
    }
}
