class Solution {
    public int solution(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            maxLength = Math.max(maxLength, Math.max(len1, len2));
        }
        return maxLength;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
