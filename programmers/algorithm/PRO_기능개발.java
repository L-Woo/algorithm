import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>(); 
        List<Integer> list = new ArrayList<>();
        
        int[] arr = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        int day = q.poll();
        int cnt= 1;
        while(!q.isEmpty()) {
            if (day >= q.peek()) {
                cnt++;
                q.poll();
            } else {
                list.add(cnt);
                cnt = 1;
                day = q.poll();
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
