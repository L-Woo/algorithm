import java.io.*;
import java.util.*;

public class Main {

    static long mod = 1000000007;

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken()) * 10;
        long ans = (func(P, N) * K % mod);

        System.out.println(ans);
    }

    static long func(long P, long N) {
        if(N == 1) {
            return P;
        }

        long num = func(P, N / 2);
        if(N % 2 == 1) {
            return (num * num % mod) * P % mod;
        }else {
            return num * num % mod;
        }
    }
}
