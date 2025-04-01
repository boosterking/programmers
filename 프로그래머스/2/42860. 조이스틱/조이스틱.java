class Solution {
    public int solution(String name) {
        int vertical = 0;
        int horizontal = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            vertical += Math.min(c - 'A', 'Z' - c + 1);

            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            horizontal = Math.min(horizontal, i * 2 + name.length() - next);
            horizontal = Math.min(horizontal, (name.length() - next) * 2 + i);
        }
        
        return vertical + horizontal;
    }
}
