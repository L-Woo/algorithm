import java.util.*;
class Solution {
    
    static int R, C;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();
        
        visited = new boolean[R][C][4];
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                for(int d = 0; d < 4; d++) {
                    if(!visited[r][c][d]) {
                        list.add(light(grid, r, c, d));
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static int light(String[] grid, int r, int c, int d) {
        int cnt = 0;
        while(true) {
            if(visited[r][c][d]) break;
            
            cnt++;
            visited[r][c][d] = true;
            
            if(grid[r].charAt(c) == 'L') d = (d + 3) % 4;
            else if(grid[r].charAt(c) == 'R') d = (d + 1) % 4;
            
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        
        return cnt;
    }
}
