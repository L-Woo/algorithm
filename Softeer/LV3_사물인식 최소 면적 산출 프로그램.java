import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int ans = Integer.MAX_VALUE;
    static List<Point>[] list;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[K + 1];
        
        for (int i = 1; i <= K; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[k].add(new Point(x, y));
        }
        dfs(1, -1001, -1001, 1001, 1001);
        System.out.println(ans);
    }

    static void dfs(int depth, int max_y, int max_x, int min_y, int min_x) {
        if (depth > K) {
            ans = Math.min(ans, Math.abs(max_x - min_x) * Math.abs(max_y - min_y));
            return;
        }
        for (int i = 0; i < list[depth].size(); i++) {
            int Nmax_x = Math.max(max_x, list[depth].get(i).x);
            int Nmax_y = Math.max(max_y, list[depth].get(i).y);
            int Nmin_x = Math.min(min_x, list[depth].get(i).x);
            int Nmin_y = Math.min(min_y, list[depth].get(i).y);
            int area = Math.abs(Nmax_x - Nmin_x) * Math.abs(Nmax_y - Nmin_y);
            if (area < ans || depth == 1) {
                dfs(depth + 1, Nmax_y, Nmax_x, Nmin_y, Nmin_x);
            }
        }
    }

    
}
