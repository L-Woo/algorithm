package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {

    static class Cave implements Comparable<Cave> {
        int r, c, cost;

        public Cave(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cave o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int ans = 0;

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = dijkstra();
            System.out.println("Problem " + idx + ":" + " " + ans);
            idx++;
        }

    }

    static int dijkstra() {

        PriorityQueue<Cave> pq = new PriorityQueue<>();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        pq.add(new Cave(0, 0, map[0][0]));
        dp[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Cave cur = pq.poll();

            if (cur.r == N - 1 && cur.c == N - 1) {
                return cur.cost;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (cur.cost + map[nr][nc] < dp[nr][nc]) {
                        dp[nr][nc] = cur.cost + map[nr][nc];
                        pq.add(new Cave(nr, nc, cur.cost + map[nr][nc]));
                    }
                }
            }
        }
        return -1;
    }

}
