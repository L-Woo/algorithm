package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_두용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans[0] = arr[left];
                ans[1] = arr[right];
                if(sum == 0) break;
            }
            if(sum < 0) left++;
            else right--;
        }

        System.out.println(ans[0] + " " + ans[1]);

    }

}
