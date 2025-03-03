import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        
        m = replaceSharps(m);
        
        for(String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String title = info[2];
            String melody = replaceSharps(info[3]);
            
            int playTime = getPlayTime(info[0], info[1]);
            String playedMelody = getPlayedMelody(melody, playTime);
            
            if(playedMelody.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }
        
        return answer;
    }
    
    private String replaceSharps(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("A#", "a")
                     .replace("B#", "b");
    }
    
    private int getPlayTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        int startMinutes = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int endMinutes = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        
        return endMinutes - startMinutes;
    }
    
    private String getPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
}