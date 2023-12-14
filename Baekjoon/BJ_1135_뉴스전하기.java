package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1135_뉴스전하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        List<Integer>[] childList = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            childList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for(int i = 1; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            childList[parent].add(i);
        }

        for(int i = N - 1; i >= 0; i--) {
            if(childList[i].size() == 0) continue;

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            for(int num : childList[i]) {
                pq.add(new int[]{dp[num], num});
            }

            int time = 1;
            int max = 0;
            while(!pq.isEmpty()) {
                max = Math.max(pq.poll()[0] + time++, max);
            }
            dp[i] = max;
        }
        System.out.println(dp[0]);
    }

}
