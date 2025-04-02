public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int d = n - 1; 
        int p = n - 1;
        
        while(d >= 0 || p >= 0) {
            while(d >= 0 && deliveries[d] == 0) d--;
            while(p >= 0 && pickups[p] == 0) p--;
            
            if(d < 0 && p < 0) break;

            int maxDist = Math.max(d + 1, p + 1);
            totalDistance += maxDist * 2;

            int remain = cap;
            while(d >= 0 && remain > 0) {
                if(deliveries[d] > remain) {
                    deliveries[d] -= remain;
                    remain = 0;
                }
                else {
                    remain -= deliveries[d];
                    deliveries[d] = 0;
                    d--;
                }
            }

            remain = cap;
            while(p >= 0 && remain > 0) {
                if(pickups[p] > remain) {
                    pickups[p] -= remain;
                    remain = 0;
                } 
                else {
                    remain -= pickups[p];
                    pickups[p] = 0;
                    p--;
                }
            }
        }
        
        return totalDistance;
    }
}
