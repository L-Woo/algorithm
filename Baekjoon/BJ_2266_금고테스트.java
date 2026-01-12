package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2266_금고테스트 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] dp = new int[N + 1][K + 1];
    
    for(int i = 1; i <= N; i++) {
      dp[i][1] = i;
    }

    for(int i = 2; i <= N; i++) {
      for(int j = 2; j <= K; j++) {
        dp[i][j] = Integer.MAX_VALUE;

        for(int k = 1; k <= i; k++) {
          int res = 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]);

          if(res < dp[i][j]) {
            dp[i][j] = res;
          }
        }
      }
    }
    System.out.println(dp[N][K]);
  }
}
