package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1189_컴백홈 {

    static int R, C, K, ans;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1) {
            if (cnt == K) ans++;
            return;
        }

        if (cnt > K) return;

        for (int d = 0; d < 4; d++) {

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            if (!visited[nr][nc] && map[nr][nc] == '.') {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1);
                visited[nr][nc] = false;
            }
        }
    }
}
