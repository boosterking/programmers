class Solution {
    public long solution(int w, int h) {
        long width = w;
        long height = h;
        long gcd = getGCD(width, height);
        return width * height - (width + height - gcd);
    }
    
    private long getGCD(long a, long b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}
