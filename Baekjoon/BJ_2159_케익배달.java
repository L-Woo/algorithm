package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_2159_케익배달 {
    static int N;
    static long[][] dp;
    static int[][] pos;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = new int[N + 1][2];
      
        for (int i = 0; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N + 1][5];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < 5; i++) {
            int nx = pos[1][0] + dx[i];
            int ny = pos[1][1] + dy[i];
            dp[1][i] = getDist(pos[0][0], pos[0][1], nx, ny);
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 5; j++) {
                int curX = pos[i][0] + dx[j];
                int curY = pos[i][1] + dy[j];

                for (int k = 0; k < 5; k++) { 
                    int prevX = pos[i - 1][0] + dx[k];
                    int prevY = pos[i - 1][1] + dy[k];
                    long dist = getDist(prevX, prevY, curX, curY);
                    if (dp[i - 1][k] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + dist);
                    }
                }
            }
        }
      
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            ans = Math.min(ans, dp[N][i]);
        }
        System.out.println(ans);
    }

    static long getDist(int x1, int y1, int x2, int y2) {
        return (long) Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
