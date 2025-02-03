class Solution {
    public int solution(int n) {
        int mod = 1234567;
        int a = 0;
        int b = 1;
        int result = 0;
        
        for (int i = 2; i <= n; i++) {
            result = (a + b) % mod;
            a = b;
            b = result;
        }
        
        return result;
    }
}
