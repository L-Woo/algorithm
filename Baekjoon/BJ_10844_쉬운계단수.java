package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10844_쉬운계단수 {

    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans = (ans + dp[N][i]) % MOD;
        }
        System.out.println(ans);
    }

}
