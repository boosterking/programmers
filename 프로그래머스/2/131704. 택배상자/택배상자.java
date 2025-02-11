import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> subContainer = new Stack<>();
        int boxCount = 0;
        int currentBox = 1;

        for(int i = 0; i < order.length; i++) {
            container.offer(i + 1);
        }

        for(int targetBox : order) {
            while(!container.isEmpty() && container.peek() < targetBox) {
                subContainer.push(container.poll());
            }

            if(!container.isEmpty() && container.peek() == targetBox) {
                container.poll();
                boxCount++;
            } 
            else if(!subContainer.isEmpty() && subContainer.peek() == targetBox) {
                subContainer.pop();
                boxCount++;
            } 
            else break;
        }

        return boxCount;
    }
}
