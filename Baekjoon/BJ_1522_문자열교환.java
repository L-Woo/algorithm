package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1522_문자열교환 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCnt = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') aCnt++;
        }

        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                int idx = j % str.length();
                if (str.charAt(idx) == 'b') bCnt++;
            }
            ans = Math.min(ans, bCnt);
        }
        System.out.println(ans);
    }

}
