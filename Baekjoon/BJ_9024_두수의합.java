package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_9024_두수의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = N - 1;
            int cnt = 0;
            int num = Integer.MAX_VALUE;

            while (left < right) {

                int sum = arr[left] + arr[right];
                int diff = Math.abs(sum - K);

                if (diff == num) {
                    cnt++;
                } else if (diff < num) {
                    cnt = 1;
                    num = diff;
                }

                if (sum == K) {
                    left++;
                    right--;
                } else if (sum > K) {
                    right--;
                } else {
                    left++;
                }
            }
            System.out.println(cnt);
        }
    }
}
