class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int removedZeros = 0;
        
        while(!s.equals("1")) {
            int originalLength = s.length();
            s = s.replaceAll("0", "");
            int newLength = s.length();
            
            removedZeros += originalLength - newLength;
            s = Integer.toBinaryString(newLength);
            convertCount++;
        }
        
        return new int[]{convertCount, removedZeros};
    }
}
