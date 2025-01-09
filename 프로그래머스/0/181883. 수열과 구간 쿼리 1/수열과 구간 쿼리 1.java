class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int[] query : queries) {
            int s = query[0];
            int e = query[1];
            
            for(int i = 0; i < arr.length; i++) {
                if(s <= i && e >= i) {
                    arr[i]++;
                }
            }
        }
        
        return arr;
    }
}