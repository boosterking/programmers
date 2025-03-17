class Solution {
    public int solution(String s) {
        int minLength = s.length();
        int maxUnit = s.length() / 2;
        
        for(int unit = 1; unit <= maxUnit; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;
            
            for(int i = unit; i < s.length(); i += unit) {
                int end = Math.min(i + unit, s.length());
                String current = s.substring(i, end);
                
                if(current.equals(prev)) count++;
                else {
                    appendCompressed(compressed, count, prev);
                    prev = current;
                    count = 1;
                }
            }
            
            appendCompressed(compressed, count, prev);
            minLength = Math.min(minLength, compressed.length());
        }
        
        return minLength;
    }
    
    private void appendCompressed(StringBuilder compressed, int count, String prev) {
        if(count > 1) compressed.append(count);
        compressed.append(prev);
    }
}
