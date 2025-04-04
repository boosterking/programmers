import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> candidates = generateCombinations(n);
        int count = 0;
        for(int[] candidate : candidates) {
            boolean valid = true;
            for(int i = 0; i < q.length; i++) {
                int[] attempt = q[i];
                int expected = ans[i];
                int actual = countCommon(candidate, attempt);
                if(actual != expected) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                count++;
            }
        }
        return count;
    }

    private List<int[]> generateCombinations(int n) {
        List<int[]> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, 5);
        return result;
    }

    private void backtrack(List<int[]> result, List<Integer> current, int start, int n, int k) {
        if(current.size() == k) {
            int[] arr = new int[k];
            for(int i = 0; i < k; i++) {
                arr[i] = current.get(i);
            }
            result.add(arr);
            return;
        }
        for(int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }

    private int countCommon(int[] a, int[] b) {
        int i = 0, j = 0, count = 0;
        while(i < a.length && j < b.length) {
            if(a[i] == b[j]) {
                count++;
                i++;
                j++;
            } 
            else if(a[i] < b[j]) {
                i++;
            } 
            else {
                j++;
            }
        }
        return count;
    }
}
