import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < 24; i++) {
            while(!pq.isEmpty() && pq.peek() <= i) {
                server--;
                pq.poll();
            }
            
            int capacity = server * m;
            if(capacity > players[i]) {
                continue;
            }
  
            int addServer = (players[i] / m) - server;
            for(int j = 0; j < addServer; j++) {
                pq.add(i + k);
            }
            answer += addServer;
            server = pq.size();
        }
        return answer;
    }
}
