class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(idx - 1 < i && arr[i] == 1) {
                return i;
            }
        }
        
        return answer;
    }
}