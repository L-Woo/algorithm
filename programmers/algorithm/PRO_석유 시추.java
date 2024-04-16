import java.util.*;

class Solution {

    static int R, C;
    static int[] line;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public int solution(int[][] land) {
        int answer = 0;

        R = land.length;
        C = land[0].length;
        line = new int[C];
        visited = new boolean[R][C];

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (!visited[r][c] && land[r][c] == 1) drill(r, c, land);
            }     
        }
        for(int sum : line) {
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    static void drill(int r, int c, int[][] land) {
        
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;

        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            set.add(cur[1]);
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (!visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        for (int idx : set) {
            line[idx] += cnt;
        }
        
    }
}
