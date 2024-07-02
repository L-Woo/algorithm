package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19951_태상이의훈련소생활 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 2];
        st = new StringTokenizer(in.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;
            int k = Integer.parseInt(st.nextToken());

            dp[start] = dp[start] + k;
            dp[end] = dp[end] + (-k);
        }

        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i];
            arr[i] += dp[i];
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }

}
