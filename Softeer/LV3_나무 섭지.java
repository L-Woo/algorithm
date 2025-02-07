import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] ghostDist;   
    static final int INF = 1_000_000_00;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        ghostDist = new int[N][M];
        List<int[]> ghostList = new ArrayList<>();
        int startR = -1, startC = -1;

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
                ghostDist[i][j] = INF;
                
                if(map[i][j] == 'G') {
                    ghostDist[i][j] = 0;
                    ghostList.add(new int[]{i, j});
                } else if(map[i][j] == 'N') {
                    startR = i;
                    startC = j;
                }
            }
        }

        solveGhostDist(ghostList);
        boolean canEscape = isEscape(startR, startC);
        System.out.println(canEscape ? "Yes" : "No");
    }

    static void solveGhostDist(List<int[]> ghostList) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] g : ghostList) {
            q.add(g); 
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int curT = ghostDist[r][c]; 

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

                if(ghostDist[nr][nc] > curT + 1) {
                    ghostDist[nr][nc] = curT + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    static boolean isEscape(int startR, int startC) {

        int[][] visited = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(visited[i], INF);
        }

        Queue<int[]> q = new ArrayDeque<>();
        visited[startR][startC] = 0;
        q.add(new int[]{startR, startC});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int time = visited[r][c];

            if(map[r][c] == 'D') {
                if(ghostDist[r][c] > time) {
                    return true; 
                }
            }

            int nt = time + 1;
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(map[nr][nc] == '#') continue;
                if(ghostDist[nr][nc] <= nt) continue;
                if(visited[nr][nc] > nt) {
                    visited[nr][nc] = nt;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
