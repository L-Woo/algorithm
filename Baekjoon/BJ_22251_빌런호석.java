package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22251_빌런호석 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = {{1, 1, 1, 0, 1, 1, 1}, // 0
                {0, 0, 1, 0, 0, 0, 1}, // 1
                {0, 1, 1, 1, 1, 1, 0}, // 2
                {0, 1, 1, 1, 0, 1, 1}, // 3
                {1, 0, 1, 1, 0, 0, 1}, // 4
                {1, 1, 0, 1, 0, 1, 1}, // 5
                {1, 1, 0, 1, 1, 1, 1}, // 6
                {0, 1, 1, 0, 0, 0, 1}, // 7
                {1, 1, 1, 1, 1, 1, 1}, // 8
                {1, 1, 1, 1, 0, 1, 1}}; // 9

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String cur = format(X, K);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            String target = format(i, K);
            if (count(cur, target, arr) <= P) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static String format(int num, int length) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(num);
        for (int i = str.length(); i < length; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    private static int count(String num1, String num2, int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < num1.length(); i++) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            if (digit1 != digit2) {
                for (int j = 0; j < 7; j++) {
                    if (arr[digit1][j] != arr[digit2][j]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
