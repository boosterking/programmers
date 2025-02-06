import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        int totalTime = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            
            if(cache.remove(city)) {
                totalTime += 1;
                cache.addFirst(city);
            } 
            else {
                totalTime += 5;
                if(cache.size() >= cacheSize) {
                    cache.removeLast();
                }
                cache.addFirst(city);
            }
        }
        
        return totalTime;
    }
}