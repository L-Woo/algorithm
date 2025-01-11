package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_31964_반품회수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o2[0] - o1[0];
        });

        int cur = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            int dist = Math.abs(arr[i][0] - cur);
            if (cur > arr[i][0]) {
                cur -= dist;
            } else {
                cur += dist;
            }

            time += dist;
            if (time < arr[i][1]) {
                time += arr[i][1] - time;
            }
        }
        time += arr[N - 1][0];
        System.out.println(time);
    }
}
