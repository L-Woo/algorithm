package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어2 {

    static class Point {
        int r, c, cnt;
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 0, 1, -1, 1, -1, 0, 1}, dc = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[][] arr;
    static int ans, N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) bfs(i, j);
            }
        }
        System.out.println(ans);
    }
    static void bfs(int r, int c) {

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c, 0));

        boolean[][] visited = new boolean[N][M];

        while(!q.isEmpty()) {

            Point cur = q.poll();

            for(int d = 0; d < 8; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if(!visited[nr][nc]) {
                    if(arr[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, cur.cnt + 1));
                    }else {
                        ans = Math.max(ans, cur.cnt + 1);
                        return;
                    }
                }
            }

        }

    }
}
