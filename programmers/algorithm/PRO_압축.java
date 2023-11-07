import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int mapIdx = 1;
        
        for(char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), mapIdx++);
        }
        
        int idx = 0;
        while(idx < msg.length()) {
            int temp = idx + 1;
            while(temp <= msg.length() && map.containsKey(msg.substring(idx, temp))) {
                temp++;
            }
            if(temp > msg.length()) {
                ans.add(map.get(msg.substring(idx)));
                break;
            }
            ans.add(map.get(msg.substring(idx, temp - 1))); 
            map.put(msg.substring(idx, temp), mapIdx++); 
            idx = temp - 1; 
        }

        return ans;
    }
}
