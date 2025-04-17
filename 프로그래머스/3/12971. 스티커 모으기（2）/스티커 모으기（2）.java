public class Solution {
    public int solution(int[] sticker) {
        if(sticker.length == 1) return sticker[0];
        int case1 = computeMax(sticker, 0, sticker.length - 2);
        int case2 = computeMax(sticker, 1, sticker.length - 1);
        return Math.max(case1, case2);
    }
    
    private int computeMax(int[] arr, int start, int end) {
        int include = 0, exclude = 0;
        for(int i = start; i <= end; i++) {
            int temp = include;
            include = exclude + arr[i];
            exclude = Math.max(exclude, temp);
        }
        return Math.max(include, exclude);
    }
}
