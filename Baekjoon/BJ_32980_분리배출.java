package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_32980_분리배출 {

    static String[] type = new String[]{"P", "C", "V", "S", "G", "F", "O"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[type.length];
        long ans = 0;

        String[] trash = new String[N];
        for (int i = 0; i < N; i++) {
            trash[i] = br.readLine();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        cost[type.length - 1] = Integer.parseInt(br.readLine());

        for (String str : trash) {
            int len = str.length();

            if (str.contains(type[type.length - 1])) {
                ans += cost[type.length - 1] * len;
            } else {
                int cnt = 0;
                int t = 0;
                for (int i = 0; i < type.length; i++) {
                    if (str.contains(type[i])) {
                        cnt++;
                        t = i;
                    }
                }

                if (cnt > 1) {
                    ans += cost[type.length - 1] * len;
                } else {
                    ans += Math.min(cost[type.length - 1] * len, cost[t] * len);
                }
            }
        }
        System.out.println(ans);
    }
}
