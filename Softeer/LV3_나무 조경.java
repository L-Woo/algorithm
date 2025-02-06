import java.io.*;
import java.util.*;

public class Main {

    static int N, ans;
    static int[] dr = {0, 1}, dc = {1, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        ans = 0;
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 2) dfs(0, 2, 0);
        else dfs(0, 4, 0);
        System.out.println(ans);
    }

    static void dfs(int depth, int target, int sum) {
        if(depth == target) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                for(int d = 0; d < 2; d++) {
                    int r = i + dr[d];
                    int c = j + dc[d];

                    if(r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
                        visited[i][j] = true;
                        visited[r][c] = true;
                        dfs(depth + 1, target, sum + map[i][j] + map[r][c]);
                        visited[i][j] = false;
                        visited[r][c] = false;
                    }
                }
            }
        }
    }
}
