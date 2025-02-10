class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int number = 0;
        while(sequence.length() < t * m) {
            sequence.append(Integer.toString(number++, n).toUpperCase());
        }

        for(int i = 0; i < t; i++) {
            answer.append(sequence.charAt((p - 1) + i * m));
        }

        return answer.toString();
    }
}