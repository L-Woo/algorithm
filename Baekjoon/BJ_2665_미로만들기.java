package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2665_미로만들기 {

    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        dijkstra();
    }

    static void dijkstra() {

        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0, 0, 0});
        visited[0][0] = true;


        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[0] == N - 1 && cur[1] == N - 1) {
                System.out.println(cur[2]);
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                if(map[nr][nc] == 0) {
                        pq.add(new int[]{nr, nc, cur[2] + 1});

                }else {
                    pq.add(new int[]{nr, nc, cur[2]});
                }
            }
        }
    }
}
