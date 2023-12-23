package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1107_리모컨 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10];

        Arrays.fill(arr, true);

        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = false;
            }
        }

        int ans = Math.abs(N - 100);

        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = true;

            for(int j = 0; j < len; j++) {
                if(!arr[str.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                int min = Math.abs(N - i) + len;
                ans = Math.min(ans, min);
            }
        }
        System.out.println(ans);
    }

}
