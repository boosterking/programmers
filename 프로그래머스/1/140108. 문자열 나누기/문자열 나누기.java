class Solution {
    public int solution(String s) {
        int count = 0;
        char x = ' ';
        int xCount = 0;
        int otherCount = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(x == ' ') {
                x = s.charAt(i);
                xCount = 1;
                otherCount = 0;
            }
            else if (s.charAt(i) == x) {
                xCount++;
            }
            else {
                otherCount++;
            }
            
            if(xCount == otherCount || i == s.length() - 1) {
                count++;
                x = ' ';
                xCount = 0;
                otherCount = 0;
            }
        }
        return count;
    }
}