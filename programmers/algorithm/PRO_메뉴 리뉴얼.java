import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int len : course) {
            for(String order : orders) {
                comb("", order, len);
            }
            
            if(!map.isEmpty()) {
                
                List<Integer> cntList = new ArrayList<>(map.values());
                int max = Collections.max(cntList);
                
                if(max > 1) {
                    for(String key : map.keySet()) {
                        if(map.get(key) == max) {
                            list.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static void comb(String order, String others, int count) {
        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
            
        for(int i = 0; i < others.length(); i++) {
            comb(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
