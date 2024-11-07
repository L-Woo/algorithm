package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13144_ListOfUniqueNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] cnt = new int[N + 1];
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int l = 1;
        int r = 0;

        while (l <= N) {
            while (r + 1 <= N && cnt[arr[r + 1]] == 0) {
                r++;
                cnt[arr[r]]++;
            }
            ans += r - l + 1;
            cnt[arr[l++]]--;
        }
        System.out.println(ans);
    }
}
