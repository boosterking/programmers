import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);
        while(k != 1) {
            k = (k % 2 == 0) ? k / 2 : k * 3 + 1;
            sequence.add(k);
        }
        
        int n = sequence.size() - 1;
        double[] cumulative = new double[sequence.size()];
        cumulative[0] = 0.0;

        for(int i = 1; i < sequence.size(); i++) {
            double area = (sequence.get(i-1) + sequence.get(i)) / 2.0;
            cumulative[i] = cumulative[i-1] + area;
        }

        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            int endX = n + b;
            
            if(a > endX || a > n || endX < 0) {
                answer[i] = -1.0;
            } 
            else {
                answer[i] = cumulative[endX] - cumulative[a];
            }
        }
        return answer;
    }
}
