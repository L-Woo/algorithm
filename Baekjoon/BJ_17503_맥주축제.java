package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17503_맥주축제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] beers = new int[K][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken());
            beers[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(beers, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int ans = -1;
        int sum = 0;

        for (int[] beer : beers) {
            pq.add(beer[0]);
            sum += beer[0];

            if (pq.size() > N) {
                sum -= pq.poll();
            }
            if (pq.size() == N && sum >= M) {
                ans = beer[1];
                break;
            }
        }
        System.out.println(ans);
    }

}
