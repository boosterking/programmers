class Solution {
    public int solution(int num, int k) {
        String numstr = String.valueOf(num);
        String kstr = String.valueOf(k);
        
        int idx = numstr.indexOf(kstr);
        
        return idx == -1 ? -1 : idx + 1;
    }
}