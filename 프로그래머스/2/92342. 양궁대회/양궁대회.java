import java.util.*;

class Solution {
    private static int maxDiff = -1;
    private static List<int[]> answers = new ArrayList<>();
    private static int[] apeach;

    public int[] solution(int n, int[] info) {
        apeach = info;
        dfs(0, n, new int[11]);

        if (answers.isEmpty()) return new int[]{-1};

        answers.sort((a, b) -> {
            for(int i = 10; i >= 0; i--) {
                if(a[i] != b[i]) return b[i] - a[i];
            }
            return 0;
        });

        return answers.get(0);
    }

    private void dfs(int index, int remaining, int[] ryan) {
        if(index == 11) {
            ryan[10] += remaining;
            calculateScore(ryan);
            ryan[10] -= remaining;
            return;
        }

        dfs(index + 1, remaining, ryan);

        int required = apeach[index] + 1;
        if(remaining >= required) {
            ryan[index] += required;
            dfs(index + 1, remaining - required, ryan);
            ryan[index] -= required;
        }
    }

    private void calculateScore(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;

        for(int i = 0; i < 11; i++) {
            if(ryan[i] > apeach[i]) ryanScore += (10 - i);
            else if(apeach[i] > 0) apeachScore += (10 - i);
        }

        int diff = ryanScore - apeachScore;
        if(diff > 0 && diff > maxDiff) {
            maxDiff = diff;
            answers.clear();
            answers.add(ryan.clone());
        } 
        else if(diff > 0 && diff == maxDiff) answers.add(ryan.clone());
    }
}
