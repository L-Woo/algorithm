package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18428_감시피하기 {
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static char[][] map;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static List<int[]> teacherList = new ArrayList<>();
    static String ans = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                char ch = st.nextToken().charAt(0);
                if(ch == 'T') teacherList.add(new int[] {i, j});
                map[i][j] = ch;
            }
        }
        comb(0);
        System.out.println(ans);
    }

    static void comb(int depth) {
        if(depth == 3) {
            if (check()) {
                ans = "YES";
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'X') {
                    map[i][j] = 'O';
                    comb(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static boolean check() {

        Queue<Point> q = new ArrayDeque<>();
        for(int[] arr : teacherList) q.add(new Point(arr[0], arr[1]));

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.r;
                int nc = cur.c;

                while(true) {
                    nr += dr[d];
                    nc += dc[d];
                    if(!isValid(nr, nc)) break;
                    if(map[nr][nc] == 'O' || map[nr][nc] == 'T') break;
                    if(map[nr][nc] == 'S') return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }

}
