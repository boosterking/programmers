import java.util.*;

class Solution {
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private boolean checkPartition(char[][] seats, int r1, int c1, int r2, int c2) {
        int r = Math.abs(r1 - r2);
        int c = Math.abs(c1 - c2);

        if(r + c > 2) return true;
        if(r + c == 1) return false;

        if(r1 == r2 && c == 2 && seats[r1][Math.min(c1, c2) + 1] != 'X') return false;
        if(c1 == c2 && r == 2 && seats[Math.min(r1, r2) + 1][c1] != 'X') return false;
        if(r == 1 && c == 1 && (seats[r1][c2] != 'X' || seats[r2][c1] != 'X')) return false;

        return true;
    }

    private boolean isManhattan(char[][] seats) {
        ArrayList<Point> position = new ArrayList<Point>();
        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats.length; j++) {
                if(seats[i][j] == 'P') {
                    position.add(new Point(i, j));
                }
            }
        }

        int size = position.size();
        if (size == 0) return true;

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                Point p1 = position.get(i);
                Point p2 = position.get(j);
                if(getDistance(p1, p2) <= 2 && !checkPartition(seats, p1.x, p1.y, p2.x, p2.y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            char[][] seats = new char[5][5];
            for(int j = 0; j < 5; j++) {
                seats[j] = places[i][j].toCharArray();
            }
            answer[i] = isManhattan(seats) ? 1 : 0;
        }
        return answer;
    }
}
