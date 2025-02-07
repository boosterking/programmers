import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = getMultiset(str1);
        List<String> list2 = getMultiset(str2);
        
        int intersection = getIntersectionSize(list1, list2);
        int union = list1.size() + list2.size() - intersection;
        
        if(union == 0) return 65536;
        
        double jaccard = (double) intersection / union;
        return (int)(jaccard * 65536);
    }
    
    private List<String> getMultiset(String str) {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        for(int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if(Character.isLetter(c1) && Character.isLetter(c2)) {
                list.add(c1 + "" + c2);
            }
        }
        return list;
    }
    
    private int getIntersectionSize(List<String> list1, List<String> list2) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : list1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;
        for(String s : list2) {
            if(map.containsKey(s) && map.get(s) > 0) {
                count++;
                map.put(s, map.get(s) - 1);
            }
        }
        return count;
    }
}
