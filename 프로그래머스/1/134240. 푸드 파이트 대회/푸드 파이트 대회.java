class Solution {
    public String solution(int[] food) {
        StringBuilder s = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            s.append(String.valueOf(i).repeat(count));
        }
        
        String left = s.toString();
        s.append("0");
        
        s.append(new StringBuilder(left).reverse());        
        
        return s.toString();
    }
}