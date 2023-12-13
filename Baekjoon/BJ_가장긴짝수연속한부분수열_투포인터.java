package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22862_가장긴짝수연속한부분수열_투포인터 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                arr[i] = true;
            }
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int ans = 0;

        while (end < N) {

            if (arr[end]) {
                ans = Math.max(ans, end - start + 1 - cnt);
                end++;
            } else if (cnt < K) {
                cnt++;
                end++;
            } else {
                if (!arr[start]) {
                    cnt--;
                }
                start++;
            }

        }
        System.out.println(ans);
    }

}
