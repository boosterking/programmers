class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int start = section[0];
        
        for(int i = 1; i < section.length; i++) {
            if(section[i] - start >= m) {
                count++;
                start = section[i];
            }
        }
        
        return count + 1;
    }
}