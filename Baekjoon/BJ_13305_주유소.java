package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] cost = new int[N];
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) dist[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int curCost = Integer.parseInt(st.nextToken());
            if(min > curCost) {
                cost[i] = curCost;
                min = curCost;
            }
            cost[i] = min;
        }

        for(int i = 0; i < N - 1; i++) {
            ans += ((long) cost[i] * dist[i]);
        }
        System.out.println(ans);
    }

}
