package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_13022_늑대와올바른단어 {
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        cnt = new int[4];
        Map<Character, Integer> map = new HashMap<>();
        map.put('w', 0);
        map.put('o', 1);
        map.put('l', 2);
        map.put('f', 3);
        boolean flag = true;

        cnt[map.get(str.charAt(0))] = 1;
        for (int i = 1; i < str.length(); i++) {
            int prev = map.get(str.charAt(i - 1));
            int cur = map.get(str.charAt(i));
            int diff = cur - prev;

            if (diff == -3) {
                if (cntCheck()) {
                    cnt[cur]++;
                } else {
                    flag = false;
                    break;
                }
            } else {
                if (diff == 1 || diff == 0) {
                    cnt[cur]++;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!cntCheck()) flag = false;
        System.out.println(flag ? 1 : 0);
    }
    static boolean cntCheck() {
        return cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3];
    }
}
