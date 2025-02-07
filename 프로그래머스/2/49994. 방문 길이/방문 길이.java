import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> routes = new HashSet<>();
        int x = 0, y = 0;
        
        for(char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            
            switch(dir) {
                case 'U': ny = Math.min(5, y + 1); break;
                case 'D': ny = Math.max(-5, y - 1); break;
                case 'R': nx = Math.min(5, x + 1); break;
                case 'L': nx = Math.max(-5, x - 1); break;
            }
            
            if(x != nx || y != ny) {
                routes.add(x + "," + y + "," + nx + "," + ny);
                routes.add(nx + "," + ny + "," + x + "," + y);
                x = nx;
                y = ny;
            }
        }
        
        return routes.size() / 2;
    }
}
