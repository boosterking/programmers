class Solution {
    public long solution(int price, int money, int count) {
        long cost = 0;
        for(int i = 1; i <= count; i++) {
            cost += (long)price * i;
        }
        
        long shortfall = cost - money;

        return shortfall > 0 ? shortfall : 0;
    }
}