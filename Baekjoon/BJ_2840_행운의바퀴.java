package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2840_행운의바퀴 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] check = new int[26];
        char[] arr = new char[N + 1];
        boolean flag = true;
        Arrays.fill(check, -1);
        Arrays.fill(arr, '?');

        int idx = 0;

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int rotation = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            idx = (idx + rotation) % N;

            if(idx <= 0) idx = N;
            if(arr[idx] != '?' && arr[idx] != ch) {
                flag = false;
                break;
            }
            int num = ch -'A';
            if(check[num] == -1) {
                arr[idx] = ch;
                check[num] = idx;
            }
            else {
                if (check[num] != idx) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            for (int i = 0; i < N; i++) {
                if(idx < 1) idx = N;
                System.out.print(arr[idx]);
                idx--;
            }
        }else {
            System.out.println("!");
        }

    }
}
