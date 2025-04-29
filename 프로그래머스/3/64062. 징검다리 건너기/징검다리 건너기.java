class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200000000;
        int answer = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            if(canAcrossRiver(stones, k, mid)) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } 
            else max = mid - 1;
        }
        return answer;
    }

    private boolean canAcrossRiver(int[] stones, int k, int friends) {
        int skip = 0;
        for(int stone : stones) {
            if(stone - friends < 0) skip++;
            else skip = 0;
            if(skip == k) return false;
        }
        return true;
    }
}
