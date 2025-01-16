class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String str = String.valueOf(k);
        
        for(int l = i; l <= j; l++) {
            answer += String.valueOf(l).length() - String.valueOf(l).replace(str, "").length();
        }
        return answer;
    }
}