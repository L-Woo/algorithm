package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] ans = new int[M];
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            ans[i] = binarySearch(target);
        }

        for(int i = 0; i < M; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int binarySearch(int target) {

        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                return 1;
            }else if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return 0;
    }

}
