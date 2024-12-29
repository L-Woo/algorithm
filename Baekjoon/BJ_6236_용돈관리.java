package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6236_용돈관리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] money = new int[N];

        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max += money[i];
            min = Math.max(min, money[i]);
        }

        int mid, cnt, sum;

        while (min <= max) {
            mid = (min + max) / 2;

            sum = 0;
            cnt = 1;

            for (int i = 0; i < N; i++) {
                sum += money[i];
                if (sum > mid) {
                    sum = money[i];
                    cnt++;
                }
            }
            if (cnt > M) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);
    }
}
