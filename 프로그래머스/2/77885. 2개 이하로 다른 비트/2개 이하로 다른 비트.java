import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers).map(this::f).toArray();
    }
    
    private long f(long x) {
        if(x % 2 == 0) {
            return x + 1;
        } 
        else {
            long bit = 1;
            while((x & bit) != 0) {
                bit <<= 1;
            }
            return x + bit / 2;
        }
    }
}
