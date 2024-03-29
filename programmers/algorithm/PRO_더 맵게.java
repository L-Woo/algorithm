import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) pq.add(scoville[i]);
  
        
        while(true) {
            
            int num = pq.poll();  
            
            if(num < K) {
                if(pq.size() < 1) {
                    answer = -1;
                    break;
                }
                int temp = pq.poll() * 2 + num;
                answer++;
                pq.add(temp);
            } else { 
                break;
            }
        }
        
        return answer;
    }
}
