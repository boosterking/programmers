import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] timeline = new int[24 * 60 + 10];
        
        for(String[] time : book_time) {
            int start = convertToMinutes(time[0]);
            int end = convertToMinutes(time[1]) + 10;
            
            timeline[start]++;
            timeline[end]--;
        }
        
        int rooms = 0;
        int maxRooms = 0;
        for(int i = 0; i < timeline.length; i++) {
            rooms += timeline[i];
            maxRooms = Math.max(maxRooms, rooms);
        }
        
        return maxRooms;
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
