package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {

    static int N, ans;
    static int[][] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        arr = new int[N][N];
        selected = new boolean[N];

        for(int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
             for(int j = 0; j < N; j++) {
                 arr[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        comb(0, 0);
        System.out.println(ans);
    }

    static void comb(int cnt, int idx) {
        if(cnt == N/2) {
            check();
            return;
        }
        for(int i = idx; i < N; i++) {
            selected[i] = true;
            comb(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

    static void check() {

        int start = 0;
        int link = 0;
        for(int i  = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(selected[i] == true && selected[j] == true) start += arr[i][j] + arr[j][i];
                else if(selected[i] == false && selected[j] == false) link += arr[i][j] + arr[j][i];
            }
        }
        ans = Math.min(ans, Math.abs(start - link));
    }

}

