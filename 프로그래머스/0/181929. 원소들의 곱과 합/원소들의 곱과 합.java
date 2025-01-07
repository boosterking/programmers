class Solution {
    public int solution(int[] num_list) {
        int pro = 1;
        int sum = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            pro *= num_list[i];
            sum += num_list[i];
        }
        return pro < sum * sum ? 1 : 0;
    }
}