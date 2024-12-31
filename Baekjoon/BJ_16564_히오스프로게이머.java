package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16564_히오스프로게이머 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ans = 0;
        int min = arr[0];
        int max = arr[N - 1];
        while (min <= max) {

            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) sum += mid - arr[i];
                if (sum > K) break;
            }
            if (sum <= K) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
