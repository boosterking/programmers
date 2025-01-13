class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0, pro = 1;
        
        for(int num : num_list) {
            sum += num;
            pro *= num;
        }
        
        return answer = num_list.length > 10 ? sum : pro;
    }
}