package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1515_수이어쓰기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int ans = 0;
        int idx = 0;
        while(true) {
            ans++;
            String target = String.valueOf(ans);
            for(int i = 0; i < target.length(); i++) {
                if(target.charAt(i) == str.charAt(idx)) idx++;
                if(idx == str.length()) {
                    System.out.println(ans);
                    return;
                }
            }
        }
    }

}
