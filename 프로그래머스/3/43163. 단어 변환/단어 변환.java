import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if(!wordSet.contains(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(begin);
        visited.add(begin);
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                if(current.equals(target)) return steps;
                generateNextWords(current, wordSet, visited, queue);
            }
            steps++;
        }
        
        return 0;
    }
    
    private void generateNextWords(String current, Set<String> wordSet, Set<String> visited, Queue<String> queue) {
        char[] arr = current.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char originalChar = arr[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == originalChar) continue;
                arr[i] = c;
                String nextWord = new String(arr);
                if(wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
            arr[i] = originalChar;
        }
    }
}
