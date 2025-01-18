package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562_나이트의이동 {
    static int N;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2}, dc = {-1, -2, -2, -1, 1, 2, 2, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            dfs(startR, startC, endR, endC);
        }

    }

    static void dfs(int startR, int startC, int endR, int endC) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == endR && cur[1] == endC) {
                System.out.println(cur[2]);
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (isValid(nr, nc)) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, cur[2] + 1});
                    }
                }
            }
        }
    }
    static boolean isValid(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}
