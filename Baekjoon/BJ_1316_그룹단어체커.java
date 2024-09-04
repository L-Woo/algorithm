package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1316_그룹단어체커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int[] check = new int[26];

            String str = br.readLine();

            char ch = str.charAt(0);

            for(int j = 1; j < str.length(); j++) {
                if(ch != str.charAt(j)) {
                    check[ch - 'a']++;
                    ch = str.charAt(j);
                }
            }
            check[ch - 'a']++;

            boolean flag = true;
            for(int j = 0; j < check.length; j++) {
                if(check[j] > 1) {
                    flag = false;
                    break;
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);
    }

}
