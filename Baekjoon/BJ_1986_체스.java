package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1986_체스 {

    static int n, m;
    static int[][] map;
    static int[] qr = {0, 1, 0, -1, -1, -1, 1, 1}, qc = {1, 0, -1, 0, -1, 1, 1, -1},
        kr = {-2, -2, -1, 1, 2, 2, -1, 1}, kc = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];


        for(int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            for(int c = 0; c < cnt; c++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = i;
            }
        }
        queenMove();
        knightMove();

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void queenMove() {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(map[i][j] == 1) {

                    for(int d = 0; d < 8; d++) {
                        int nr = i + qr[d];
                        int nc = j + qc[d];

                        while(isValid(nr, nc)) {
                            if(map[nr][nc] == 0 || map[nr][nc] == 4) {
                                    map[nr][nc] = 4;
                                    nr += qr[d];
                                    nc += qc[d];
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    static void knightMove() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(map[i][j] == 2) {
                    for(int d = 0; d < 8; d++) {
                        int nr = i + kr[d];
                        int nc = j + kc[d];

                        if(isValid(nr, nc) &&  map[nr][nc] == 0) {
                            map[nr][nc] = 4;
                        }
                    }
                }
            }
        }
    }

    static boolean isValid(int r, int c){
        return r > 0 && c > 0 && r <= n && c <= m;
    }
}
