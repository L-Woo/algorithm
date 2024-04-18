import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int R, C;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static List<Integer> list;
    
    public List<Integer> solution(String[] maps) {
        
        R = maps.length;
        C = maps[0].length();
        visited = new boolean[R][C];
        list = new ArrayList<>();
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(!visited[r][c] && maps[r].charAt(c) != 'X') bfs(r, c, maps);
            }
        }
        
        Collections.sort(list);
        if(list.size() == 0) list.add(-1);
        
        return list;
    }
    
    static void bfs(int r, int c, String[] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        int sum = maps[r].charAt(c) - '0';
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll(); 
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                
                if(!visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    sum += maps[nr].charAt(nc) - '0';
                }
            }
        }
        list.add(sum);
    }
}
