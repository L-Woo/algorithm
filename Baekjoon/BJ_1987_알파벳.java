package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
    static int ans, R, C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] check = new boolean[26];
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 1;

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }
        visited[0][0] = true;
        check[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(ans);

    }

    static void dfs(int r, int c, int cnt) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

            int alpha = map[nr][nc] - 'A';

            if (!visited[nr][nc] && !check[alpha]) {
                visited[nr][nc] = true;
                check[alpha] = true;
                ans = Math.max(ans, cnt + 1);
                dfs(nr, nc, cnt + 1);
                visited[nr][nc] = false;
                check[alpha] = false;
            }
        }
    }
}
