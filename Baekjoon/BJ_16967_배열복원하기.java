package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16967_배열복원하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int R = H + X;
        int C = W + Y;

        int[][] arr = new int[R][C];
        int[][] ans = new int[H][W];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(arr[i][j] == 0) continue;
                if(i >= X && j >= Y) ans[i][j] = arr[i][j] - ans[i - X][j - Y];
                else if(i < X || j < Y) ans[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
