package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        // 지도에 제외시킬 영역을 설정
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for(int r = r1; r < r2; r++) {
                for(int c = c1; c < c2; c++) {
                    map[r][c] = 1;
                }
            }

        }

        List<Integer> list = new ArrayList<>();
        // bfs를 통해서 구한 넓이를 list에 저장
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int num : list) {
            System.out.print(num + " ");
        }

    }
    // bfs 실행
    // 분리된 영역의 넓이를 탐색해서 그 넓이 값을 반환
    static int bfs(int r, int c) {

        int cnt = 1;
        map[r][c] = 1;

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));

        while(!q.isEmpty()) {

            Point p = q.poll();

            for(int d = 0; d < 4; d++) {

                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= M || nc >= N) {
                    continue;
                }

                if(map[nr][nc] == 0) {
                    map[nr][nc] = 1;
                    cnt++;
                    q.add(new Point(nr, nc));
                }

            }

        }
        return cnt;

    }

}
