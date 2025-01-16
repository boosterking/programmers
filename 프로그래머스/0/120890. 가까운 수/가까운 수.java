class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int minD = Math.abs(n - array[0]);
        
        for(int i = 1; i < array.length; i++) {
            int d = Math.abs(n - array[i]);
            
            if(d < minD || (d == minD && array[i] < answer)) {
                minD = d;
                answer = array[i];
            }
        }
        return answer;
    }
}