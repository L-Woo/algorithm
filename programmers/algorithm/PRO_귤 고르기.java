import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for(int num : list) {
            
            k -= num;
            answer++;
            
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}
