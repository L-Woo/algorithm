package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2666_벽장문의이동 {

    static int[] opens = new int[2];
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 2; i++) {
            opens[i] = Integer.parseInt(st.nextToken());
        }

        int len = Integer.parseInt(br.readLine());
        arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(func(0, opens[0], opens[1]));

    }

    static int func(int cnt, int a, int b) {
        if(cnt == arr.length) return 0;

        int tmp1 = Math.abs(a - arr[cnt]);
        int tmp2 = Math.abs(b - arr[cnt]);
        return Math.min(tmp1 + func(cnt + 1, b, arr[cnt]),
            tmp2 + func(cnt + 1, a, arr[cnt]));
    }

}
