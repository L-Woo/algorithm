import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int len = cards.length;
        boolean[] visited = new boolean[len];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int cur = i;
            int cnt = 0;
            
            while(!visited[cur]) {
                visited[cur] = true;
                cur = cards[cur] - 1;
                cnt++;
            }
            list.add(cnt);
        }
        Collections.sort(list, Comparator.reverseOrder());

        return list.get(0) * list.get(1);
    }
}
