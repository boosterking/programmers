class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;
        
        for (String key : keyinput) {
            switch (key) {
                case "left":
                    x = Math.max(x - 1, -maxX);
                    break;
                case "right":
                    x = Math.min(x + 1, maxX);
                    break;
                case "up":
                    y = Math.min(y + 1, maxY);
                    break;
                case "down":
                    y = Math.max(y - 1, -maxY);
                    break;
            }
        }
        
        return new int[]{x, y};
    }
}