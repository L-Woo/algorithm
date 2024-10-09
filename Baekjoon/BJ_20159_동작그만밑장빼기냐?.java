package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정훈이 부터 카드를 가져간다. -> 분배하는 사람부터 카드를 가져간다.
// 단 한번만 밑장빼기를 할 수 있다.
// 최대 한번 밑장 빼기를 할 때 얻을 수 있는 최대 카드의 합을 구하여라

// 누적합

public class BJ_20159_동작그만밑장빼기냐 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        // 정훈이 카드
        int[] dp1 = new int[N / 2 + 1];
        // 상대방 카드
        int[] dp2 = new int[N / 2 + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N / 2; i++) {
            dp1[i] = dp1[i - 1] + Integer.parseInt(st.nextToken());
            dp2[i] = dp2[i - 1] + Integer.parseInt(st.nextToken());
        }

        ans = Math.max(dp1[N / 2], dp2[N / 2]);
        if(N == 2) {
            System.out.println(ans);
            return;
        }

        int temp = 0;
        for(int i = 0; i < N; i++) {
            // 정훈이의 차례에서 밑장 빼기를 한 경우
            if(i % 2 == 1) {
                temp = dp1[i /2] + (dp2[N / 2] - dp2[i / 2]);
            }
            // 상대 차례에서 밑장 빼기를 한 경우
            else {
                temp = dp1[i / 2 + 1] + (dp2[N / 2 - 1] - dp2[i / 2]);
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

}
