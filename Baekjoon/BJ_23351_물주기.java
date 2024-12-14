package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_23351_물주기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = K;
        }
        int day = 0;
        while (true) {
            day++;
            for (int i = 0; i < A; i++) {
                arr[i] += B;
            }
            for (int i = 0; i < N; i++) {
                arr[i] -= 1;
            }
            Arrays.sort(arr);
            if (arr[0] == 0) break;
        }
        System.out.println(day);
    }

}
