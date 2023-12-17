package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2629_양팔저울 {

    static int N, M;
    static int[] weight;
    static boolean[][] possible;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weight = new int[N + 1];
        possible = new boolean[N + 1][40001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        check(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int marble = Integer.parseInt(st.nextToken());
            if(possible[N][marble]) sb.append("Y");
            else sb.append("N");
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    static void check(int idx, int sum) {
        if(possible[idx][sum]) return;
        possible[idx][sum] = true;

        if(idx == N) return;

        check(idx + 1, sum + weight[idx]);
        check(idx + 1, sum);
        check(idx + 1, Math.abs(sum - weight[idx]));
    }

}
