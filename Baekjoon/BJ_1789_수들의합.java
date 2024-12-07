package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1789_수들의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());
        long sum = 0;
        long cnt = 0;
        long num = 1;

        while (target >= sum) {
            sum += num++;
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}
