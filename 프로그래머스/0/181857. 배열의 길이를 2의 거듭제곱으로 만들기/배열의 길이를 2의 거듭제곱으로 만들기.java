class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        int targetLength = 1;
        
        while (targetLength < length) {
            targetLength *= 2;
        } 
      
        int[] answer = new int[targetLength];
        
        System.arraycopy(arr, 0, answer, 0, length);
        return answer;
    }
}