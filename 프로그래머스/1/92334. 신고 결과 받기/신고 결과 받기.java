import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        Map<String, Integer> reportCount = new HashMap<>();
        
        int[] answer = new int[id_list.length];
        
        for(String id : id_list) {
            reportMap.put(id, new HashSet<>());
            reportCount.put(id, 0);
        }
        
        for(String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];
            
            if(!reportMap.get(reporter).contains(reported)) {
                reportMap.get(reporter).add(reported);
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }
        
        Set<String> bannedUsers = new HashSet<>();
        for(String id : id_list) {
            if(reportCount.get(id) >= k) {
                bannedUsers.add(id);
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            Set<String> reportedUsers = reportMap.get(user);
            
            for(String reported : reportedUsers) {
                if(bannedUsers.contains(reported)) answer[i]++;
            }
        }
        
        return answer;
    }
}