import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> commands = new ArrayList<>();

        for(String r : record) {
            String[] parts = r.split(" ");
            if(parts[0].equals("Enter") || parts[0].equals("Change")) {
                userMap.put(parts[1], parts[2]);
            }
            if(!parts[0].equals("Change")) {
                commands.add(new String[]{parts[0], parts[1]});
            }
        }

        String[] answer = new String[commands.size()];
        for(int i = 0; i < commands.size(); i++) {
            String[] command = commands.get(i);
            String nickname = userMap.get(command[1]);
            
            if(command[0].equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } 
            else if(command[0].equals("Leave")) {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
