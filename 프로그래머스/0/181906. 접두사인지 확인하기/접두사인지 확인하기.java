class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        String[] str = new String[my_string.length()];
        
        for(int i = my_string.length() - 1; i > 0; i--) {
            str[i] = my_string.substring(0, my_string.length() - i);
            if(str[i].equals(is_prefix)) {
                answer = 1;
            }
        }
        
        return answer;
    }
}