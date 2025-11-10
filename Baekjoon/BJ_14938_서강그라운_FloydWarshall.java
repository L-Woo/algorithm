package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14938_서강그라운_FloydWarshall {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    final int MOD = 1000000000;

    int[][] dist = new int[n + 1][n + 1];
    int[] item = new int[n + 1];

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(i == j) {
          dist[i][j] = 0;
        }else {
          dist[i][j] = MOD;
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= n; i++) {
      item[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      dist[a][b] = Math.min(dist[a][b], weight);
      dist[b][a] = Math.min(dist[b][a], weight);
    }

    for(int k = 1; k <= n; k++) {
      for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    int ans = 0;
    for(int i = 1; i <= n; i++) {
      int cnt = 0;
      for(int j = 1; j <= n; j++) {
        if(dist[i][j] <= m && dist[i][j] != MOD) {
          cnt += item[j];
        }
      }
      ans = Math.max(ans, cnt);
    }
    System.out.println(ans);
  }
}
