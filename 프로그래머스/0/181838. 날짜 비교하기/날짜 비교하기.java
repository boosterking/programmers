class Solution {
    public int solution(int[] date1, int[] date2) {
        int answer = 0; 
        String tmp1 = "";
        String tmp2 = "";
        
        for(int i = 0; i < date1.length; i++) {
            tmp1 += String.valueOf(date1[i]);
            tmp2 += String.valueOf(date2[i]);
        }
        if(Integer.parseInt(tmp1) < Integer.parseInt(tmp2)) {
            answer = 1;
        }
        
        return answer;
    }
}