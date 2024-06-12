package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20310_타노스 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') cnt0++;
            else cnt1++;
        }

        cnt0 /= 2;
        cnt1 /= 2;

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, ' ');
                cnt0--;
            }
            if (cnt0 == 0) break;
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, ' ');
                cnt1--;
            }
            if (cnt1 == 0) break;
        }

        System.out.println(sb.toString().replaceAll(" ", ""));
    }

}
