package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BJ_2116_주사위쌓기 {

    static int[] opposite = {5, 3, 4, 1, 2, 0};
    static int N, ans = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 6; i++) {
            func(1, 0, i);
        }
        System.out.println(ans);
    }

    static void func(int depth, int sum, int idx) {

        int max = 0;

        for(int i = 0; i < 6; i++) {
            if(i == idx || i == opposite[idx]) continue;
            max = Math.max(max, arr[depth - 1][i]);

        }
        sum += max;

        if(depth == N) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0; i < 6; i++){
            if(arr[depth - 1][idx] == arr[depth][i]){
                func(depth + 1, sum, opposite[i]);
                break;
            }
        }
    }

}
