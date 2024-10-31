package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1941_소문난칠공주 {
    static char[][] map = new char[5][5];
    static boolean[] visited;
    static int[] choose = new int[7];
    static int ans;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;

        for(int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }

    static void comb(int cnt, int start, int sCnt) {
        if(cnt - sCnt > 3) return;
        if(cnt == 7) {
            visited = new boolean[7];
            bfs(choose[0] / 5, choose[0] % 5);
            return;
        }
        for(int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            choose[cnt] = i;
            comb(cnt + 1, i + 1, map[r][c] == 'S' ? sCnt + 1: sCnt);
        }
    }
    static void bfs(int r, int c) {
        int cnt = 1;
        visited[0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {

                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                int next = 5 * nr + nc;
                for(int i = 0; i < 7; i++) {
                    if(!visited[i] && choose[i] == next) {
                        visited[i] = true;
                        cnt++;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        if(cnt == 7) ans++;
    }

}
