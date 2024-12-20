package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_13910_개업 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        int[] woks = new int[M];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> wokComb = new HashSet<>();
        for (int i = 0; i < woks.length; i++) {
            wokComb.add(woks[i]);

            for (int j = i + 1; j < woks.length; j++) {
                wokComb.add(woks[i] + woks[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int wok : wokComb) {
                if (i - wok < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - wok] + 1);
            }
        }
        System.out.println(dp[N] != 987654321 ? dp[N] : -1);
    }
}
