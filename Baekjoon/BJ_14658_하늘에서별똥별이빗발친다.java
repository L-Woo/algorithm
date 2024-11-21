package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14658_하늘에서별똥별이빗발친다 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<int[]> stars = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stars.add(new int[] {r, c});
        }

        for(int[] s1 : stars) {
            for(int[] s2 : stars) {
                int r = s1[0];
                int c = s2[1];
                int cnt = 0;

                for(int[] target : stars) {
                    if(target[0] >= r && target[0] <= r + L && target[1] >= c && target[1] <= c + L) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(K - ans);
    }
}
