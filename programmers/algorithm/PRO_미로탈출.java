import java.util.*;
class Solution {
    
    static int R, C;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for(int i  = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if(maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        int ans1 = bfs(start, 'L', maps);
        int ans2 = bfs(lever, 'E', maps);
        
        if(ans1 == -1 || ans2 == -1) return -1;
        return ans1 + ans2;
    }
    
    static int bfs(int[] pos, char target, String[] maps) {
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {pos[0], pos[1], 0});
        
        boolean[][] visited = new boolean[R][C];
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            
            if(maps[cur[0]].charAt(cur[1]) == target) {
                return cur[2];
            }
            
            for(int d = 0; d < 4; d++) {
                int nr =  cur[0] + dr[d];
                int nc =  cur[1] + dc[d];
                
                if(nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
                       if (maps[nr].charAt(nc) != 'X') {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, cur[2] + 1});
                    }
                }
            }
            
        }
        return -1;
    }
    
}
