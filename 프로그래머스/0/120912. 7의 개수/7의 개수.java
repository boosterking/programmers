class Solution {
    public int solution(int[] array) {
        String str = "";
        for(int num : array) {
            str += String.valueOf(num);
        }
        int answer = 0;
        
        for(char c : str.toCharArray()) {
            if(c == '7') {
                answer++;
            }
        }
        return answer;
    }
}