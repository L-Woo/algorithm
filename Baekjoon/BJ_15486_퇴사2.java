package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) max = dp[i];

            int next = i + arr[i][0];
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }
        System.out.println(dp[N + 1]);
    }
}
