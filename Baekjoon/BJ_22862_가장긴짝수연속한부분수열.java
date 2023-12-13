package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_22862_가장긴짝수연속한부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        int cnt = 0;
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num % 2 == 0) {
              cnt++;
            }else if(q.size() < K) {
                q.add(i);
            }else {
                cnt = i - q.poll() - K;
                q.add(i);
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }

}
