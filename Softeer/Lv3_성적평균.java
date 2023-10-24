import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken()) + dp[i - 1];
        }

        for(int i = 0; i < K; i++) {
            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = dp[b] - dp[a - 1];

            double ans = (double)temp / (b - a + 1);
            String str = String.format("%.2f", ans);

            System.out.println(str);

        }
 
    }
}
