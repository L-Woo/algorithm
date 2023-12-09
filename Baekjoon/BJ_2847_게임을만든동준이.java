package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2847_게임을만든동준이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 1; i--) {
            if(arr[i] <= arr[i - 1]) {
                int temp = arr[i - 1] - arr[i] + 1;
                ans += temp;
                arr[i - 1] = arr[i - 1] - temp;
            }
        }

        System.out.println(ans);

    }

}
