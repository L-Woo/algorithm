import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            if(!map.containsKey(a)) {
                map.put(a, new int[] {0, 0});
            }
            if(!map.containsKey(b)) {
                map.put(b, new int[] {0, 0});
            }
            map.get(a)[0] += 1;
            map.get(b)[1] += 1;
        }
        
        for(int key : map.keySet()) {
    		int[] arr = map.get(key);
    
    		if(arr[0] >= 2 && arr[1] == 0 ) answer[0] = key;
    		else if(arr[0] == 0 && arr[1] > 0) answer[2]++;
    		else if(arr[0] >= 2 && arr[1] >= 2) answer[3]++;
    	}
        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}
