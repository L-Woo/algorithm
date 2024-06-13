package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11501_주식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            long ans = 0;
            int max = arr[N - 1];
            for(int i = N - 2; i >= 0; i--) {
                if(arr[i] <= max) ans += max - arr[i];
                else max = arr[i];
            }

            System.out.println(ans);
        }

    }

}
