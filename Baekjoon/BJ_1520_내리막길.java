package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1520_내리막길 {

    static int N, M, ans;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(dfs(1, 1));
    }

    static int dfs(int r, int c) {
        if (r == N && c == M) return 1;
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isValid(nr, nc) && map[r][c] > map[nr][nc]) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    }

    static boolean isValid(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= M;
    }
}
