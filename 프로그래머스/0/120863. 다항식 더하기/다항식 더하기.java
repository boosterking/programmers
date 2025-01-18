class Solution {
    public String solution(String polynomial) {
        int constant = 0;
        int xCoefficient = 0;
        
        for (String term : polynomial.split(" \\+ ")) {
            if (term.contains("x")) {
                xCoefficient += term.equals("x") ? 1 : Integer.parseInt(term.replace("x", ""));
            } else {
                constant += Integer.parseInt(term);
            }
        }
        
        StringBuilder result = new StringBuilder();
        if (xCoefficient != 0) {
            result.append(xCoefficient == 1 ? "x" : xCoefficient + "x");
        }
        if (constant != 0) {
            if (result.length() > 0) result.append(" + ");
            result.append(constant);
        }
        
        return result.length() > 0 ? result.toString() : "0";
    }
}