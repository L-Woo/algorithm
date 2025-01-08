package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3079_입국심사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long ans = Long.MAX_VALUE;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 0;
        long right = (long) arr[N - 1] * M;

        while (left <= right) {

            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i];
                if (cnt >= M) break;
            }
            if (cnt >= M) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
