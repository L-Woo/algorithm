import java.io.*;
import java.util.*;

public class Main {

    static int N, M, cnt;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cnt++;    
            }
        }
        int ans = 0;
        while(cnt > 0) {
            bfs();  
            ans++;
        }

        System.out.println(ans);
    }

    static void bfs() {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        int[][] visited = new int[N][M];
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {

            int[] arr = q.poll();

            for(int d = 0; d < 4; d++) {

                int nr = arr[0] + dr[d];
                int nc = arr[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if(visited[nr][nc] == 0 && map[nr][nc] == 0){
                    q.add(new int[] {nr, nc});
                    visited[nr][nc]++;
                }else if(map[nr][nc] == 1) {
                    visited[nr][nc]++;
                }
                
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(visited[r][c] >= 2) {
                    map[r][c] = 0;
                    cnt--;
                }
            }
        }
        
    }
}
