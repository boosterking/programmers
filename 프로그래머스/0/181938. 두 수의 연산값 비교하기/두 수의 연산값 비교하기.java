class Solution {
    public int solution(int a, int b) {
        String ab1 = String.valueOf(a) + String.valueOf(b);
        int ab2 = 2 * a * b;
        
        if (Integer.parseInt(ab1) >= ab2) {
            return Integer.parseInt(ab1);
        } 
        else {
            return ab2;
        }
    }
}