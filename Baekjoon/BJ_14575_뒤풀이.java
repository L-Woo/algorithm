package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14575_뒤풀이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        int lSum = 0;
        int rSum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            lSum += arr[i][0];
            rSum += arr[i][1];
        }

        int min = 0;
        int max = T;

        if (lSum > T || rSum < T) {
            System.out.println(-1);
        } else {
            while (min <= max) {

                int mid = (min + max) / 2;
                int sum = 0;

                boolean flag = false;
                for (int i = 0; i < N; i++) {
                    if (arr[i][0] > mid) {
                        flag = true;
                        break;
                    }
                    sum += Math.min(arr[i][1], mid);
                }
                if (flag) {
                    min = mid + 1;
                    continue;
                }
                if (sum >= T) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(min);
        }
    }
}
