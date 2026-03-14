package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_5052_전화번호목록 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            boolean flag = true;
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            for (int i = 0; i < N - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }

    }

}
