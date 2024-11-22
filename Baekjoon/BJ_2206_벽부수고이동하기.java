package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {

    static class Point{
        int r, c, cnt;
        boolean destroy;


        public Point(int r, int c, int cnt, boolean destroy) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.destroy = destroy;
        }
    }

    static int N, M, ans;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                int num = str.charAt(j - 1) - '0';
                map[i][j] = num;
            }
        }
        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(1, 1, 1, false));
        visited[1][1][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if(cur.r == N && cur.c == M) {
                ans = Math.min(ans, cur.cnt);
                return;
            }

            for(int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc= cur.c + dc[d];
                int nCnt = cur.cnt + 1;

                if(nr < 1 || nr > N || nc < 1 || nc > M) continue;

                if (map[nr][nc] == 0) {
                    if(!cur.destroy && !visited[nr][nc][0]) {
                        visited[nr][nc][0] = true;
                        q.add(new Point(nr,nc, nCnt, false));
                    }else if(cur.destroy && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        q.add(new Point(nr,nc, nCnt, true));
                    }
                }else {
                    if(!cur.destroy) {
                        visited[nr][nc][1] = true;
                        q.add(new Point(nr, nc, nCnt, true));
                    }
                }
            }
        }

    }

}
