public class Solution {
    public long solution(int r1, int r2) {
        long total = 0;
        for(int x = 0; x <= r2; x++) {
            long lower = Math.max(0, (long) r1 * r1 - (long) x * x);
            long upper = (long) r2 * r2 - (long) x * x;
            if(upper < 0) continue;
            long yMin = (long) Math.ceil(Math.sqrt(lower));
            long yMax = (long) Math.floor(Math.sqrt(upper));
            if(yMin > yMax) continue;
            long count = yMax - yMin + 1;
            if(x == 0) total += count * 2;
            else {
                if(yMin == 0) total += 2 + 4 * yMax;
                else total += 4 * count;
            }
        }
        return total;
    }
}
