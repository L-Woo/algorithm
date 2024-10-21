package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1456_거의소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] isPrime = new boolean[(int) Math.sqrt(B) + 1];

        for(int i = 2; i < isPrime.length; i++) isPrime[i] = true;

        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) continue;
            for(int j = i * 2; j < isPrime.length; j += i) isPrime[j] = false;
        }

        int ans = 0;

        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i]) {
                long temp = i;

                while(temp <= (double) B / i) {
                    if(temp >= (double) A / i) ans++;
                    temp *= i;
                }
            }
        }
        System.out.println(ans);
    }

}
