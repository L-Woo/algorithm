package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11687_팩토리얼0의개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M * 5;
        boolean flag = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;

            for (int i = 5; i <= mid; i *= 5) {
                cnt += mid / i;
            }

            if (cnt > M) {
                right = mid - 1;
            } else if (cnt == M) {
                right = mid - 1;
                flag = true;
            } else {
                left = mid + 1;
            }
        }
        if (flag) System.out.println(left);
        else System.out.println(-1);
    }
}
