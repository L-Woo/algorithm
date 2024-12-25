package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2792_보석상자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        int left = 1;
        int right = 0;
        int ans = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {

            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
