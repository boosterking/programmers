import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0], x = bandage[1], y = bandage[2];
        int maxHealth = health;
        int lastAttackTime = attacks[attacks.length - 1][0];
        Map<Integer, Integer> attackMap = new HashMap<>();
        
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }
        
        int currentHealth = health;
        int continuousTime = 0;
        
        for (int time = 1; time <= lastAttackTime; time++) {
            if (attackMap.containsKey(time)) {
                currentHealth -= attackMap.get(time);
                continuousTime = 0;
                if (currentHealth <= 0) {
                    return -1;
                }
            } else {
                currentHealth = Math.min(currentHealth + x, maxHealth);
                continuousTime++;
                if (continuousTime == t) {
                    currentHealth = Math.min(currentHealth + y, maxHealth);
                    continuousTime = 0;
                }
            }
        }
        
        return currentHealth;
    }
}