import java.util.*;

class Solution {
    
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static int R, C, answer;
    
    static class Point {
        
        int r, c, cnt;
        
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        answer = -1;
        
        R = board.length;
        C = board[0].length();
        int startR = 0, startC = 0;
        boolean flag = false;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i].charAt(j) == 'R') {
                    startR = i;
                    startC = j;
                    flag = true;
                    break;
                } 
            }
            if(flag) break;
        }
        bfs(startR, startC, board);
        
        return answer;
    }
    
    static void bfs(int r, int c, String[] board) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c, 0));
        boolean[][] visited = new boolean[R][C];
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            
            Point p = q.poll();
            
            if(board[p.r].charAt(p.c) == 'G') {
                answer = p.cnt;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c;
                
                while(isRange(nr, nc) && board[nr].charAt(nc) != 'D') {
                    nr += dr[d];
                    nc += dc[d];
                }
                
                nr -= dr[d];
                nc -= dc[d];
                
                if(visited[nr][nc] || (p.r == nr && p.c == nc)) continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, p.cnt + 1));
            }
        }
        
        
    }
    
    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
    
    
}
