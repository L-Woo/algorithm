package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19941_햄버거분배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;
        boolean[] eat = new boolean[N];

        String str = br.readLine();

        for(int i = 0; i < N; i++) {
            if(str.charAt(i) == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
                for(int j = start; j <= end; j++) {
                    if(!eat[j] && str.charAt(j) == 'H') {
                        eat[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
