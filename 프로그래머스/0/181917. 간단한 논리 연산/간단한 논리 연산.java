class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean a = (x1 || x2) ? true : false;
        boolean b = (x3 || x4) ? true : false;
         
        return answer = (a && b) ? true : false;
    }
}