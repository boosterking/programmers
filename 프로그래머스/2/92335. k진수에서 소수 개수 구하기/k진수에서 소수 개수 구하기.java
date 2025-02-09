import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] numbers = converted.split("0");
        int count = 0;
        
        for(String num : numbers) {
            if(!num.isEmpty() && isPrime(Long.parseLong(num))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long n) {
        if(n < 2) return false;
        for(long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
