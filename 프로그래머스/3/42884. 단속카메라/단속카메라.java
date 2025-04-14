import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cameraCount = 0;
        int lastCamera = -30001;
        
        for(int[] route : routes) {
            if(route[0] > lastCamera) {
                cameraCount++;
                lastCamera = route[1];
            }
        }
        
        return cameraCount;
    }
}
