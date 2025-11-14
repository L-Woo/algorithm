package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1756_피자굽기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[D + 1];
        int[] oven = new int[D + 1];
        int[] pizza = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= D; i++) {
            if(oven[i - 1] < oven[i]) {
                oven[i] = oven[i - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int ans = 0;
        for(int i = D; i >= 1; i--) {
            if(idx >= N) break;
            if(oven[i] >= pizza[idx]) {
                ans = i;
                idx++;
            }
        }

        if(idx < N) {
            System.out.println(0);
        }else {
            System.out.println(ans);
        }
    }

}
