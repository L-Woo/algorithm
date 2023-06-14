import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1388_바닥장식 {

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = 0;

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) {
                    continue;
                }
                char ch = arr[i][j];
                dfs(i, j, ch);
                ans++;
            }
        }

        System.out.println(ans);

    }

    static void dfs(int r, int c, char cur) {

        visited[r][c] = true;

        if(cur == '-') {
            if(c + 1 < M && arr[r][c + 1] == '-') {
                dfs(r, c + 1, cur);
            }
        }else if(r + 1 < N && arr[r + 1][c] == '|') {
            dfs(r + 1, c, cur);
        }

    }

}
