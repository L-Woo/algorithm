package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20922_겹치는건싫어 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < N) {
            while (right < N && cnt[arr[right]] + 1 <= K) {
                cnt[arr[right]]++;
                right++;
            }
            ans = Math.max(ans, right - left);
            cnt[arr[left]]--;
            left++;
        }
        System.out.println(ans);
    }

}
