class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int idx = 0;
        for(int[] part : parts) {

            int s = part[0];
            int e = part[1];
            
            for(int i = s; i < e + 1; i++) {
                answer += my_strings[idx].charAt(i);
            }
            idx++;
        }
        
        return answer;
    }
}