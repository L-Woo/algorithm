package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2179_비슷한단어 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        int max = 0;
        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!list.contains(str)) list.add(str);
        }

        for (int i = 0; i < N - 1; i++) {
            String str1 = list.get(i);

            for (int j = i + 1; j < N; j++) {
                String str2 = list.get(j);
                int cnt = 0;
                int len = Math.min(str1.length(), str2.length());

                for (int k = 0; k < len; k++) {
                    if (str1.charAt(k) != str2.charAt(k)) break;
                    cnt++;
                }
                if (cnt > max) {
                    max = cnt;
                    ans1 = i;
                    ans2 = j;
                }
            }
        }
        System.out.println(list.get(ans1));
        System.out.println(list.get(ans2));
    }

}
