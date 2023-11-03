import java.io.*;
import java.util.*;

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int N, M, ans;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Point[] destination;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        destination = new Point[M];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Point p = new Point(r, c);
            destination[i] = p;
        }

        visited[destination[0].r][destination[0].c] = true;
        dfs(destination[0], 1);
        System.out.println(ans);
    }

    static void dfs(Point p, int idx) {
        if (idx == M) {
            ans++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = p.r + dir[i][0];
            int nc = p.c + dir[i][1];

            if (nr < 1 || nc < 1 || nr > N || nc > N) continue;

            if (nr == destination[idx].r && nc == destination[idx].c && !visited[nr][nc] && map[nr][nc] != 1) {
                visited[nr][nc] = true;
                dfs(new Point(nr, nc), idx + 1);
                visited[nr][nc] = false;
            } else if(!visited[nr][nc] && map[nr][nc] != 1) {
                visited[nr][nc] = true;
                dfs(new Point(nr, nc), idx);
                visited[nr][nc] = false;
            }
        }
    }
}
