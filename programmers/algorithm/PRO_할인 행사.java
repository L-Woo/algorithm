import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 10 + 1; i++) {
            Map<String, Integer> curMap = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                curMap.put(discount[j], curMap.getOrDefault(discount[j], 0) + 1);
            }
            boolean flag = true;
            for(String key : want) {
                if(map.get(key) != curMap.get(key)) {
                    flag = false;
                    break;
                }
            } 
            if(flag) answer++;
            
        }
        
        return answer;
    }
}
