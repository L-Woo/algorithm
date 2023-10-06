import java.util.*;

class Solution {
    
    static List<int[]> list;
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(1, 2, 3, n);
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
    void hanoi(int s, int v, int e, int n) {
        int[] move = {s, e};
        if(n == 1) list.add(move);
        else {
            hanoi(s, e, v, n - 1);
            list.add(move);
            hanoi(v, s, e, n - 1);
        }
    }
}
