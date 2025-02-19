import java.util.*;

class Solution {
    boolean[] isPrime = new boolean[10000000];
    boolean[] used = new boolean[7];
    int[] nums;
    HashSet<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        nums = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) nums[i] = numbers.charAt(i) - '0';

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i < 10000000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < 10000000; j += i) isPrime[j] = false;
            }
        }

        dfs(0, 0);

        return primes.size();
    }

    private void dfs(int depth, int number) {
        if(isPrime[number]) primes.add(number);

        if(depth == nums.length) return;

        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                dfs(depth + 1, number * 10 + nums[i]);
                used[i] = false;
            }
        }
    }
}
