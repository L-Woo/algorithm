import java.util.*;

class Solution {
    
    static class Task {
        String name;
        int start;
        int time;
        
        public Task(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
    
    public String[] solution(String[][] plans) {

        StringTokenizer st;
        int len = plans.length;
        String[] answer = new String[len];
         
        PriorityQueue<Task> pq = new PriorityQueue<>((o1 , o2) -> (o1.start - o2.start));
        Stack<Task> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(plans[i][1], ":");
            String name = plans[i][0];
            int hour = Integer.parseInt(st.nextToken()) * 60;
            int min = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Task(name, hour + min, time));
        }
        int idx = 0;
        Task cur = pq.poll();
        int curTime = cur.start;
        
        while(true) {
            if(!pq.isEmpty() && curTime + cur.time > pq.peek().start) {
                stack.add(new Task(cur.name, cur.start, cur.time - (pq.peek().start - curTime)));
                cur = pq.poll();
                curTime = cur.start;
            }else {
                answer[idx++] = cur.name;
                curTime += cur.time;
                
                if(!pq.isEmpty() && curTime == pq.peek().start) cur = pq.poll();
                else if(!stack.isEmpty()) cur = stack.pop();
                else if(!pq.isEmpty()) {
                    cur = pq.poll();
                    curTime = cur.start;
                }
                else break;
            }
        }
        
        return answer;
    }
}
