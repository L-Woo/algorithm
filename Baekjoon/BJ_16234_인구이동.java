package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16234_인구이동 {

    static int N, L, R;
    static boolean isMove;
    static int[][] population;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) bfs(i, j);
                }
            }
            if (!isMove) break;
            else ans++;
        }
        System.out.println(ans);
    }

    static void bfs(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        List<Point> list = new ArrayList<>();
        q.add(new Point(r, c));
        list.add(new Point(r, c));
        visited[r][c] = true;

        int sum = population[r][c];

        while (!q.isEmpty()) {

            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isVaild(nr, nc)) continue;
                if (!visited[nr][nc]) {
                    int temp = Math.abs(population[cur.r][cur.c] - population[nr][nc]);
                    if (temp >= L && temp <= R) {
                        isMove = true;
                        visited[nr][nc] = true;
                        sum += population[nr][nc];
                        list.add(new Point(nr, nc));
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }
        divide(list, sum);
    }

    static void divide(List<Point> list, int sum) {
        for (Point p : list) {
            population[p.r][p.c] = sum / list.size();
        }
    }

    static boolean isVaild(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
