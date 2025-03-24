import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Plan> list = new ArrayList<>();
        for(String[] p : plans) {
            String name = p[0];
            int start = convertTime(p[1]);
            int playtime = Integer.parseInt(p[2]);
            list.add(new Plan(name, start, playtime));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);
        
        Deque<Plan> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        Plan current = null;
        int currentTime = 0;
        
        for(Plan plan : list) {
            if(current == null) {
                current = plan;
                currentTime = current.start;
            } 
            else {
                int available = plan.start - currentTime;
                if(available > 0) {
                    int remainingTime = available;
                    while(remainingTime > 0 && (current != null || !stack.isEmpty())) {
                        if(current == null) current = stack.pop();
                        if(current.remaining <= remainingTime) {
                            result.add(current.name);
                            remainingTime -= current.remaining;
                            currentTime += current.remaining;
                            current = null;
                        } 
                        else {
                            current.remaining -= remainingTime;
                            currentTime += remainingTime;
                            remainingTime = 0;
                        }
                    }
                }
                if(current != null) {
                    stack.push(current);
                    current = null;
                }
                current = plan;
                currentTime = plan.start;
            }
        }
        
        if(current != null) result.add(current.name);
        while(!stack.isEmpty()) result.add(stack.pop().name);
        
        return result.toArray(new String[0]);
    }
    
    private int convertTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    static class Plan {
        String name;
        int start;
        int remaining;
        
        Plan(String n, int s, int r) {
            name = n;
            start = s;
            remaining = r;
        }
    }
}
