import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;
        int maxSize = Math.min(n, m);  // 가능한 최대 크기

        // mats를 내림차순으로 정렬
        Arrays.sort(mats);
        for (int i = 0, j = mats.length - 1; i < j; i++, j--) {
            int temp = mats[i];
            mats[i] = mats[j];
            mats[j] = temp;
        }

        // 각 크기에 대해 확인
        for (int size : mats) {
            if (size > maxSize) continue;
            if (canPlaceMat(park, size)) {
                return size;
            }
        }

        return -1;
    }

    private boolean canPlaceMat(String[][] park, int size) {
        int n = park.length;
        int m = park[0].length;

        for (int i = 0; i <= n - size; i++) {
            for (int j = 0; j <= m - size; j++) {
                if (isValidSquare(park, i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidSquare(String[][] park, int startI, int startJ, int size) {
        for (int i = startI; i < startI + size; i++) {
            for (int j = startJ; j < startJ + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
