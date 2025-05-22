import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> crewTimes = new ArrayList<>();
        for(String time : timetable) {
            crewTimes.add(convertToMinutes(time));
        }
        Collections.sort(crewTimes);
        
        int index = 0;
        int lastTime = 0;
        int currentTime = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            currentTime = 540 + i * t;
            count = 0;
            while(index < crewTimes.size() && crewTimes.get(index) <= currentTime && count < m) {
                lastTime = crewTimes.get(index);
                index++;
                count++;
            }
        }
        
        if(count < m) return convertToString(currentTime);
        else return convertToString(lastTime - 1);
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    private String convertToString(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }
}
