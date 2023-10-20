package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {

    static boolean[] visit;
    static int N;
    static int[][] map;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        int INF = (int) 1e9;
        ans = 0;

        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) map[i][j] = 0;
                else {
                    map[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }
        // 플루이드-워셜
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 1; i <= N; i++) {
            if(map[1][i] > 0 && map[1][i] < INF) ans++;
        }

        System.out.println(ans);
    }
    // dfs
    // 플루이드-워셜은 모든 노드를 전부 구하다 보니까 아무래도 dfs가 속도가 더 빠르다.
    static void dfs(int start) {
        visit[start] = true;

        for(int i = 1; i <= N; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                ans++;
                dfs(i);
            }
        }
    }

}
