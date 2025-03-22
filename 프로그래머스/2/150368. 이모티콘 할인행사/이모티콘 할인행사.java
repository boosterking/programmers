public class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int maxSubscribers = 0;
        int maxSales = 0;
        int m = emoticons.length;
        int totalCombinations = (int) Math.pow(4, m);
        
        for(int comb = 0; comb < totalCombinations; comb++) {
            int[] discounts = new int[m];
            int temp = comb;
            for(int i = 0; i < m; i++) {
                int rateCode = temp % 4;
                discounts[i] = (rateCode + 1) * 10; // 10%, 20%, 30%, 40%
                temp /= 4;
            }
            
            int currentSubscribers = 0;
            int currentSales = 0;
            
            for(int[] user : users) {
                int userRate = user[0];
                int userPrice = user[1];
                int total = 0;
                
                for(int i = 0; i < m; i++) {
                    if(discounts[i] >= userRate) {
                        total += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }
                
                if(total >= userPrice) {
                    currentSubscribers++;
                } 
                else {
                    currentSales += total;
                }
            }
            
            if(currentSubscribers > maxSubscribers) {
                maxSubscribers = currentSubscribers;
                maxSales = currentSales;
            } 
            else if(currentSubscribers == maxSubscribers && currentSales > maxSales) {
                maxSales = currentSales;
            }
        }
        
        answer[0] = maxSubscribers;
        answer[1] = maxSales;
        return answer;
    }
}
