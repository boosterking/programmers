class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftHand = 10;
        int rightHand = 12;
        
        for(int number : numbers) {
            if(number == 0) number = 11;
            
            if(number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftHand = number;
            } 
            else if(number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightHand = number;
            } 
            else {
                int leftDist = getDistance(leftHand, number);
                int rightDist = getDistance(rightHand, number);
                
                if(leftDist < rightDist) {
                    answer.append("L");
                    leftHand = number;
                }
                else if(leftDist > rightDist) {
                    answer.append("R");
                    rightHand = number;
                }
                else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftHand = number;
                    } else {
                        answer.append("R");
                        rightHand = number;
                    }
                }
            }
        }
        return answer.toString();
    }
    
    private int getDistance(int from, int to) {
        int fromRow = (from - 1) / 3;
        int fromCol = (from - 1) % 3;
        int toRow = (to - 1) / 3;
        int toCol = (to - 1) % 3;
        return Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
    }
}