class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = 1;
        
        while (x <= n) {
            answer++;
            if(answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                continue;
            }
            x++;
        }
        
        return answer;
    }
}