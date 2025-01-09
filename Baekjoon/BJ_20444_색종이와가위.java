package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20444_색종이와가위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long left = 0;
        long right = N / 2;

        while (left <= right) {

            long mid = (left + right) / 2;
            long cnt = mid + 1;
            cnt *= (N - mid) + 1;
            if (cnt == K) {
                System.out.println("YES");
                return;
            } else if (cnt > K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("NO");
    }
}
