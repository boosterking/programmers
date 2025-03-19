class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        long initialTime = times[0];
        int maxDiff = 1;

        for (int i = 1; i < n; i++) {
            if(diffs[i] > maxDiff) maxDiff = diffs[i];
        }

        int low = 1;
        int high = maxDiff;
        int answer = maxDiff;

        while(low <= high) {
            int mid = (low + high) >>> 1;
            long total = initialTime;
            boolean feasible = true;

            for(int i = 1; i < n; i++) {
                int diff = diffs[i];
                int timeCur = times[i];
                int timePrev = times[i - 1];

                if (mid >= diff) total += timeCur;
                else {
                    int mistakes = diff - mid;
                    long add = (long) mistakes * (timeCur + timePrev) + timeCur;
                    total += add;
                }

                if(total > limit) {
                    feasible = false;
                    break;
                }
            }

            if(feasible) {
                answer = mid;
                high = mid - 1;
            } 
            else low = mid + 1;
        }

        return answer;
    }
}
