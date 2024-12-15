package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9082_지뢰찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] cnt = new int[N];
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                cnt[i] = str.charAt(i) - '0';
            }
            char[] landMine = br.readLine().toCharArray();

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    if (cnt[i] != 0 && cnt[i + 1] != 0) {
                        cnt[i]--;
                        cnt[i + 1]--;
                        ans++;
                    }
                } else if (i == N - 1) {
                    if (cnt[i - 1] != 0 && cnt[i] != 0) {
                        cnt[i]--;
                        cnt[i - 1]--;
                        ans++;
                    }
                } else {
                    if (cnt[i - 1] != 0 && cnt[i] != 0 && cnt[i + 1] != 0) {
                        cnt[i - 1]--;
                        cnt[i]--;
                        cnt[i + 1]--;
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
