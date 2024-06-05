package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10655_마라톤1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int dist = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                dist += Math.abs(arr[i][0] - arr[i - 1][0]) + Math.abs(arr[i][1] - arr[i - 1][1]);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            int before = Math.abs(arr[i][0] - arr[i - 1][0]) + Math.abs(arr[i][1] - arr[i - 1][1]) +
                    Math.abs(arr[i][0] - arr[i + 1][0]) + Math.abs(arr[i][1] - arr[i + 1][1]);

            int after = Math.abs(arr[i - 1][0] - arr[i + 1][0]) + Math.abs(arr[i - 1][1] - arr[i + 1][1]);

            ans = Math.min(ans, dist - before + after);
        }

        System.out.println(ans);

    }

}
