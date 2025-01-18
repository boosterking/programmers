class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int lcm = (denom1 * denom2) / getGCD(denom1, denom2);
        int numeratorSum = (lcm / denom1) * numer1 + (lcm / denom2) * numer2;
        int denominatorSum = lcm;
        int gcd = getGCD(numeratorSum, denominatorSum);
                
        return new int[] { numeratorSum / gcd, denominatorSum / gcd };
    
    }
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}