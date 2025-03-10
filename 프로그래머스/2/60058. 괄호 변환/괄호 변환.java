class Solution {
    public String solution(String p) {
        return convert(p);
    }

    private String convert(String w) {
        if(w.isEmpty()) return "";

        int splitIndex = findSplitIndex(w);
        String u = w.substring(0, splitIndex + 1);
        String v = w.substring(splitIndex + 1);

        if(isCorrect(u)) return u + convert(v);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");                    
            sb.append(convert(v));             
            sb.append(")");                    
            sb.append(reverseBrackets(u));     
            return sb.toString();              
        }
    }

    private int findSplitIndex(String w) {
        int count = 0;
        for(int i = 0; i < w.length(); i++) {
            count += (w.charAt(i) == '(') ? 1 : -1;
            if(count == 0) return i;
        }
        return w.length() - 1;
    }

    private boolean isCorrect(String u) {
        int balance = 0;
        for(char c : u.toCharArray()) {
            balance += (c == '(') ? 1 : -1;
            if(balance < 0) return false;
        }
        return true;
    }

    private String reverseBrackets(String u) {
        StringBuilder sb = new StringBuilder();
        String sub = u.substring(1, u.length() - 1);
        for(char c : sub.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
