package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {

    static int N, M;
    static int[][] map;
    // 북, 동, 남, 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean(r, c, dir));
    }

    static int clean(int r, int c, int dir) {
        int count = 0;

        while (true) {

            // 1. 현재 칸이 청소되지 않은 경우 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                count++;
            }

            boolean cleaned = false;

            // 2. 왼쪽 방향부터 4칸을 탐색
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; // 왼쪽 회전
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                // 청소되지 않은 빈 칸 발견
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    cleaned = true;
                    break;
                }
            }

            // 빈 칸을 찾았다면 1번 과정(청소)에 다시 들어감
            if (cleaned) continue;

            // 3. 빈 칸이 없다면 후진
            int back = (dir + 2) % 4;
            int nr = r + dr[back];
            int nc = c + dc[back];

            // 후진 불가 시 작동 중지
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1) {
                return count;
            }

            // 후진 가능하면 한 칸 후진
            r = nr;
            c = nc;
        }
    }

}

