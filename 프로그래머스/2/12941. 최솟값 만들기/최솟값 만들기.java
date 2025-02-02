import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length;

        Arrays.sort(A);

        Integer[] B_Integer = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B_Integer, (a, b) -> b.compareTo(a));
        
        for (int i = 0; i < n; i++) {
            answer += A[i] * B_Integer[i];
        }
        
        return answer;
    }
}