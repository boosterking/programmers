class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        boolean winO = false;
        boolean winX = false;

        for(String row : board) {
            for(char c : row.toCharArray()) {
                if(c == 'O') countO++;
                if(c == 'X') countX++;
            }
        }

        winO = checkWin(board, 'O');
        winX = checkWin(board, 'X');

        if(countX > countO || countO > countX + 1) return 0;
        if(winO && winX) return 0;
        if(winO && countO != countX + 1) return 0;
        if(winX && countO != countX) return 0;

        return 1;
    }

    private boolean checkWin(String[] board, char player) {
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
            if(board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        if(board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if(board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;
        return false;
    }
}
