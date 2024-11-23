package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_22866_탑보기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] cnt = new int[N + 1];
        int[] ans = new int[N + 1];
        Arrays.fill(ans, -100000);

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if(cnt[i] > 0) ans[i] = stack.peek();
            stack.push(i);
        }


        stack = new Stack<>();
        for(int i = N; i >= 1; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if(!stack.isEmpty() && stack.peek() - i < i - ans[i]) ans[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(cnt[i]);
            if(cnt[i] > 0) {
                sb.append(" ").append(ans[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

}
