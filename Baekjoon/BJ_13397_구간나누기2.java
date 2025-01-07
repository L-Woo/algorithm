package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13397_구간나누기2 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (divide(mid) <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    static int divide(int mid) {

        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > mid) {
                cnt++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }
        return cnt;
    }
}
