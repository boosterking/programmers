class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        
        int s = 0, e = my_string.length() - 1;
        
        while(s < e) {
            char temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
        
        return new String(arr);
    }
}