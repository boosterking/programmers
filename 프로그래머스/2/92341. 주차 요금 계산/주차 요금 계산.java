import java.util.*;
import java.text.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, String> inTime = new HashMap<>();
        
        for(String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];
            
            if(action.equals("IN")) {
                inTime.put(carNumber, time);
            } 
            else if(action.equals("OUT")) {
                String in = inTime.remove(carNumber);
                int duration = calculateDuration(in, time);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + duration);
            }
        }
        
        for(String carNumber : inTime.keySet()) {
            String in = inTime.get(carNumber);
            int duration = calculateDuration(in, "23:59");
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + duration);
        }
        
        List<String> carNumbers = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = parkingTime.get(carNumber);
            answer[i] = calculateFee(totalTime, fees);
        }
        
        return answer;
    }
    
    private int calculateDuration(String in, String out) {
        String[] inParts = in.split(":");
        String[] outParts = out.split(":");
        
        int inHour = Integer.parseInt(inParts[0]);
        int inMinute = Integer.parseInt(inParts[1]);
        int outHour = Integer.parseInt(outParts[0]);
        int outMinute = Integer.parseInt(outParts[1]);
        
        return (outHour * 60 + outMinute) - (inHour * 60 + inMinute);
    }

    private int calculateFee(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(totalTime <= basicTime) {
            return basicFee;
        } 
        else {
            return basicFee + (int)Math.ceil((double)(totalTime - basicTime) / unitTime) * unitFee;
        }
    }
}
