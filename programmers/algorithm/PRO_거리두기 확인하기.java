import java.util.*;

class Solution {
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            String[] arr = places[i];
            boolean flag = true;
            
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(arr[r].charAt(c) == 'P') {
                        if(!check(r, c, arr)) {
                            flag = false;
                            break;
                        }    
                    }
                }
                if(!flag) break;
            }
            answer[i] = flag ? 1 : 0;
        }
        
        return answer;
    }
    
    static boolean check(int r, int c, String[] arr) {
        
        Queue<int[]> q = new ArrayDeque<>(); 
        boolean[][] visited = new boolean[5][5];
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr >= 5 || nc >= 5 || nr < 0 || nc < 0) continue;
                if(visited[nr][nc]) continue;
                
                int dis = Math.abs(nr - r) + Math.abs(nc - c);
 
                if (arr[nr].charAt(nc) == 'P' && dis <= 2)
                    return false;
                else if (arr[nr].charAt(nc) == 'O' && dis < 2) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
                    
            }        
            
            
        }
        
        return true;
    }
}
