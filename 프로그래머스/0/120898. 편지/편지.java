class Solution {
    public int solution(String message) {
        message.replaceAll(" ", "");
        return 2 * message.length();
    }
}