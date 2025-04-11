import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        int count = 0;
        
        while(i < A.length && j < B.length) {
            if(B[j] > A[i]) {
                count++;
                i++;
                j++;
            } 
            else j++;
        }
        
        return count;
    }
}
