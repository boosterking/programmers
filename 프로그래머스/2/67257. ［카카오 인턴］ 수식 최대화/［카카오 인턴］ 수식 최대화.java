import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parseExpression(expression, numbers, operators);

        Set<Character> opSet = new HashSet<>(operators);
        List<Character> uniqueOps = new ArrayList<>(opSet);
        List<List<Character>> permutations = generatePermutations(uniqueOps);
        
        long max = 0;
        for(List<Character> perm : permutations) {
            long answer = evaluate(numbers, operators, perm);
            max = Math.max(max, Math.abs(answer));
        }
        
        return max;
    }
    
    private void parseExpression(String expr, List<Long> nums, List<Character> ops) {
        StringBuilder numStr = new StringBuilder();
        for(char c : expr.toCharArray()) {
            if(Character.isDigit(c)) numStr.append(c);
            else {
                nums.add(Long.parseLong(numStr.toString()));
                numStr.setLength(0);
                ops.add(c);
            }
        }
        nums.add(Long.parseLong(numStr.toString()));
    }
    
    private List<List<Character>> generatePermutations(List<Character> list) {
        List<List<Character>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), list, new boolean[list.size()]);
        return answer;
    }
    
    private void backtrack(List<List<Character>> answer, List<Character> temp, List<Character> list, boolean[] used) {
        if(temp.size() == list.size()) answer.add(new ArrayList<>(temp));
        else {
            for(int i = 0; i < list.size(); i++) {
                if(!used[i]) {
                    used[i] = true;
                    temp.add(list.get(i));
                    backtrack(answer, temp, list, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
    
    private long evaluate(List<Long> nums, List<Character> ops, List<Character> precedence) {
        List<Long> currentNums = new ArrayList<>(nums);
        List<Character> currentOps = new ArrayList<>(ops);
        
        for(char op : precedence) {
            while(true) {
                int idx = currentOps.indexOf(op);
                if(idx == -1) break;
                
                long a = currentNums.get(idx);
                long b = currentNums.get(idx + 1);
                long res = calculate(a, b, op);
                
                currentNums.remove(idx + 1);
                currentNums.set(idx, res);
                currentOps.remove(idx);
            }
        }
        return currentNums.get(0);
    }
    
    private long calculate(long a, long b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
