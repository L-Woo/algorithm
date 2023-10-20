package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        final int INF = (int) 1e9;

        int[][] dist = new int[N + 1][N + 1];


        // 플로이드-워셜 초기화

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        // 간선 정보 등록
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(t, dist[s][e]);
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // 갈 수 없는곳은 0으로 표시
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] == INF) dist[i][j] = 0;
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }

}
