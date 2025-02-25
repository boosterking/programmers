class Solution {
    public String solution(int n) {
        String[] digits = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();
        
        while(n > 0) {
            int remainder = n % 3;
            n = n / 3;
            
            if(remainder == 0) n--;
            
            answer.insert(0, digits[remainder]);
        }
        
        return answer.toString();
    }
}
