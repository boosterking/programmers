import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRank = new HashMap<>();     
        Map<Integer, String> rankPlayer = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
            rankPlayer.put(i, players[i]);
        }
        
        for(String calledPlayer : callings) {
            int currentRank = playerRank.get(calledPlayer);
            int newRank = currentRank - 1;
            String overtakenPlayer = rankPlayer.get(newRank);
            
            playerRank.put(calledPlayer, newRank);
            playerRank.put(overtakenPlayer, currentRank);
            rankPlayer.put(newRank, calledPlayer);
            rankPlayer.put(currentRank, overtakenPlayer);
        }
        
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++) {
            answer[i] = rankPlayer.get(i);
        }
        
        return answer;
    }
}