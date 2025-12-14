package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19539_사과나무 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());

            cnt1 += num % 2;
            cnt2 += num / 2;
            sum += num;
        }
        System.out.println(sum % 3 == 0 && cnt1 <= cnt2 ? "YES" : "NO");

    }

}
