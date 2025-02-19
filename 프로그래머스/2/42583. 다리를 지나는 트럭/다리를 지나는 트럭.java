import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        for(int i = 0; i < bridge_length; i++) bridge.offer(0);


        while(truckIndex < truck_weights.length) {
            time++;
            currentWeight -= bridge.poll();

            if(currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } 
            else bridge.offer(0);

        }
        return time + bridge_length;
    }
}
