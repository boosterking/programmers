import java.util.*;

public class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (String[] ticket : tickets) {
            adj.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        adj.forEach((k, v) -> v.sort((x, y) -> -x.compareTo(y)));

        List<String> path = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");

        while(!stack.isEmpty()) {
            String node = stack.peek();
            if(adj.getOrDefault(node, Collections.emptyList()).isEmpty()) {
                path.add(stack.pop());
                continue;
            }
            String neighbor = adj.get(node).remove(adj.get(node).size() - 1);
            stack.push(neighbor);
        }

        Collections.reverse(path);
        return path.toArray(new String[0]);
    }
}
