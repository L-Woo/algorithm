package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());

        Stack<Integer> st = new Stack<>();
        int idx = 0;

        while (N-- > 0) {
            int target = Integer.parseInt(in.readLine());

            if (target > idx) {
                for (int i = idx + 1; i <= target; i++) {
                    st.push(i);
                    sb.append("+\n");
                }
                idx = target;
            } else if (st.peek() != target) {
                System.out.println("NO");
                return;
            }
            st.pop();
            sb.append("-\n");
        }
        System.out.println(sb.toString());
    }

}
