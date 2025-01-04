package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16439_치킨치킨치킨 {

    static int N, M, ans = 0;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int cnt) {
        if (cnt == 3) {
            int sum = 0;
            for (int r = 0; r < N; r++) {
                int max = 0;
                for (int c = 0; c < M; c++) {
                    if (visited[c]) {
                        max = Math.max(max, arr[r][c]);
                    }
                }
                sum += max;
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
