import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> referralMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int currentProfit = amount[i] * 100;
            
            String currentPerson = currentSeller;
            
            while(true) {
                int tenPercent = currentProfit / 10;
                
                if(tenPercent < 1) {
                    profitMap.put(currentPerson, profitMap.getOrDefault(currentPerson, 0) + currentProfit);
                    break;
                }
                
                int remaining = currentProfit - tenPercent;
                profitMap.put(currentPerson, profitMap.getOrDefault(currentPerson, 0) + remaining);
                
                String referrer = referralMap.get(currentPerson);
                if("-".equals(referrer)) break;
                
                currentProfit = tenPercent;
                currentPerson = referrer;
            }
        }

        int[] result = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            result[i] = profitMap.getOrDefault(enroll[i], 0);
        }
        
        return result;
    }
}
