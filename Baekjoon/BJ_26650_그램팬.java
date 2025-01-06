package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_26650_그램팬 {

    static class Alpha {
        char alpha;
        int cnt;

        Alpha(char alpha, int cnt) {
            this.alpha = alpha;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int length = S.length();
        long ans = 0;

        if (length < 26) {
            System.out.println(ans);
            return;
        }

        List<Alpha> list = new ArrayList<>();
        int idx = 0;
        while (idx < length) {
            char cur = S.charAt(idx);
            int cnt = 1;
            while (idx + cnt < length && S.charAt(idx + cnt) == cur) {
                cnt++;
            }
            list.add(new Alpha(cur, cnt));
            idx += cnt;
        }

        int size = list.size();
        for (int i = 0; i <= size - 26; i++) {
            boolean flag = true;

            for (int j = 0; j < 26; j++) {
                char ch = (char) ('A' + j);
                if (list.get(i + j).alpha != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                long aCnt = list.get(i).cnt;
                long zCnt = list.get(i + 25).cnt;
                ans += aCnt * zCnt;
            }
        }
        System.out.println(ans);
    }
}
