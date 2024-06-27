import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(in.readLine());
        long ans = 0;
        int[] bus = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            bus[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp;
        for(int i = 0; i < N - 2; i++) {
            dp = new int[N];
            
            dp[N - 1] = bus[i] < bus[N - 1] ? 0 : 1;
            for(int j = N - 2; j >= i + 1; j--) {
                if(bus[i] > bus[j]) dp[j] = dp[j + 1] + 1;
                else {
                    dp[j] = dp[j + 1];
                    ans += dp[j];
                }
            }
        }
        System.out.println(ans);
    }
}
