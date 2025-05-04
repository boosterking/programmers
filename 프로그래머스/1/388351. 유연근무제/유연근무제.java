class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            int s = schedules[i];
            int sHour = s / 100;
            int sMin = s % 100;
            int totalMinutes = sHour * 60 + sMin + 10;
            int allowedHour = totalMinutes / 60;
            int allowedMin = totalMinutes % 60;
            int allowedTime = allowedHour * 100 + allowedMin;
            
            boolean isValid = true;
            for(int j = 0; j < 7; j++) {
                int dayOfWeek = ((startday - 1) + j) % 7 + 1;
                if(dayOfWeek >= 6) continue;
                int logTime = timelogs[i][j];
                if(logTime > allowedTime) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) count++;
        }
        
        return count;
    }
}
