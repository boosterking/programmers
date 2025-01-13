class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        double avr = (double)sum / numbers.length;
        
        return Math.round(avr * 10) / 10.0;
    }
}