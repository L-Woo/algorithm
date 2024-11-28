import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited= new boolean[N][N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});

        int cnt = 1;
        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
            
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
}
