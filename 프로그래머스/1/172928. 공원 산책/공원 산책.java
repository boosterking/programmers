class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        int[] start = findStart(park);
        int x = start[0], y = start[1];
        
        for(String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int distance = Integer.parseInt(parts[1]);
            
            int nx = x, ny = y;
            boolean canMove = true;
            
            for(int i = 0; i < distance; i++) {
                switch(direction) {
                    case 'N': nx--; break;
                    case 'S': nx++; break;
                    case 'W': ny--; break;
                    case 'E': ny++; break;
                }
                if(nx < 0 || nx >= H || ny < 0 || ny >= W || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }
            if(canMove) {
                x = nx;
                y = ny;
            }
        }
        return new int[] {x, y};
    }
    
    private int[] findStart(String[] park) {
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }
}