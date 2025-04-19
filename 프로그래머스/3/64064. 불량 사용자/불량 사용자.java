import java.util.*;

class Solution {
    private void count(int idx, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if(idx == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for(String id : bans[idx]) {
            if(banned.contains(id)) continue;
            banned.add(id);
            count(idx + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}
