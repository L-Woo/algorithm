package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18429_근손실 {

    static int N, K, ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(ans);
    }

    static void dfs(int cnt, int weight) {

        if (cnt == N) {
            ans++;
            return;
        }
        weight -= K;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && weight + arr[i] >= 500) {
                visited[i] = true;
                dfs(cnt + 1, weight + arr[i]);
                visited[i] = false;

            }
        }
    }

}
