package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2531_회전초밥 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] belt = new int[N];
        int[] eat = new int[d + 1];
        int ans = 0;
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < k; i++) {
            if(eat[belt[i]] == 0) cnt++;
            eat[belt[i]]++;
        }

        ans = eat[c] == 0 ? cnt + 1 : cnt;
        for(int i = 1; i < N; i++) {
            int left = belt[i - 1];
            int right = belt[i + k - 1 < N? i + k - 1 : (i + k - 1) % N];

            if(eat[left] == 1) cnt--;
            eat[left]--;
            if(eat[right] == 0) cnt++;
            eat[right]++;

            ans = Math.max(ans, eat[c] == 0 ? cnt + 1 : cnt);
        }
        System.out.println(ans);
    }

}
