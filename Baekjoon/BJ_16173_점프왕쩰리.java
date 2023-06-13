import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16713_점프왕쩰리 {

    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static int N;
    static int[][] map;
    static boolean[][] check;
    static String ans = "Hing";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans);

    }

    static void dfs(int r, int c) {

        if(isRange(r, c)) {
            return;
        }

        if(check[r][c]) {
            return;
        }
        if(map[r][c] == -1) {
            ans = "HaruHaru";
            return;
        }
        check[r][c] = true;
        dfs(r + map[r][c], c);
        dfs(r, c + map[r][c]);
    }

    static boolean isRange(int r, int c){
        if(r >= N || r < 0 || c >= N || c < 0) {
            return true;
        }
        return false;
    }


}
