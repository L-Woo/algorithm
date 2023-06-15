import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {

    static int N, maxHeight = Integer.MIN_VALUE, cnt, ans;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }

        for(int i = 0; i < maxHeight; i++) {
            check = new boolean[N][N];
            cnt = 0;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    if(!check[r][c] && arr[r][c] > i) {
                        cnt += dfs(r, c, i);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }

    static int dfs(int r, int c, int height) {

        check[r][c] = true;
        for(int d = 0; d < 4; d++) {

            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isRange(nr, nc)) {
                if(check[nr][nc]) {
                    continue;
                }
                if(arr[nr][nc] > height) {
                    dfs(nr, nc, height);
                }
            }

        }

        return 1;
    }

    static boolean isRange(int r, int c) {
        if(r >= N || r < 0 || c >= N || c < 0) {
            return false;
        }
        return true;
    }

}
