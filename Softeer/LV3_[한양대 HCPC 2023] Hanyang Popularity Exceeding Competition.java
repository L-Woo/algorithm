import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int temp1 = Math.abs(P - dp[i - 1][0]) <= C ? dp[i - 1][0] + 1 : dp[i - 1][0];
            int temp2 = Math.abs(P - dp[i - 1][1]) <= C ? dp[i - 1][1] + 1 : dp[i - 1][1]; 

            dp[i][0] = Math.max(temp1, temp2);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }        
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
