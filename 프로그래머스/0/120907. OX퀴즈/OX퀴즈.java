class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[2]);
            int z = Integer.parseInt(parts[4]);
            
            boolean isCorrect;
            if (parts[1].equals("+")) {
                isCorrect = (x + y == z);
            } else {
                isCorrect = (x - y == z);
            }
            
            answer[i] = isCorrect ? "O" : "X";
        }
        
        return answer;
    }
}