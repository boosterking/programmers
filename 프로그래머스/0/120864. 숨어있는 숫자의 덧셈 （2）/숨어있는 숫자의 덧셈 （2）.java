class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] numbers = my_string.replaceAll("[^0-9]+", " ").trim().split(" ");
        
        for (String number : numbers) {
            if (!number.isEmpty()) {
                answer += Integer.parseInt(number);
            }
        }
        return answer;
    }
}