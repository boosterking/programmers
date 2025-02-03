class Solution {
    public int solution(int n) {
        int countOne = Integer.bitCount(n);
        int next = n + 1;
        
        while(Integer.bitCount(next) != countOne) {
            next++;
        }
        
        return next;
    }
}
