package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1205_등수구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int rank = 1;
        int[] arr = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && score <= arr[N - 1]) {
            System.out.println(-1);
        } else {
            for(int i = 0; i < N; i++) {
                if(score < arr[i]) rank++;
                else break;
            }
            System.out.println(rank);
        }
    }
}
