package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21317_징검다리건너기 {

    static int ans, N, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        arr = new int[N + 1][2];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());

            arr[i][0] = small;
            arr[i][1] = big;
        }

        K = Integer.parseInt(br.readLine());
        dfs(0, 1, false);
        System.out.println(ans);

    }

    static void dfs(int sum, int cur, boolean flag) {
        if (cur == N) {
            ans = Math.min(ans, sum);
            return;
        }
        if (cur > N) return;

        dfs(sum + arr[cur][0], cur + 1, flag);
        dfs(sum + arr[cur][1], cur + 2, flag);

        if (!flag) {
            dfs(sum + K, cur + 3, true);
        }
    }

}
