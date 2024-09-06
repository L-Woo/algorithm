package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BJ_2193_이친수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];


        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[N]);
    }

}
