class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avr = new double[score.length];
        
        for (int i = 0; i < score.length; i++) {
            avr[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        for (int i = 0; i < score.length; i++) {
            answer[i] = 1;
            for (int j = 0; j < score.length; j++) {
                if (avr[j] > avr[i]) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}