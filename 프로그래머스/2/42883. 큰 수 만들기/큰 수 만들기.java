import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return new String(answer);
    }
}
