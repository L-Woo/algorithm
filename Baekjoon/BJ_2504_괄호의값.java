package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504_괄호의값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        String str = br.readLine();
        int ans = 0;
        int cnt = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
                cnt *= 2;
            } else if (ch == '[') {
                st.push(ch);
                cnt *= 3;
            } else {
                if (ch == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        ans = 0;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') ans += cnt;
                    st.pop();
                    cnt /= 2;
                } else {
                    if (st.isEmpty() || st.peek() != '[') {
                        ans = 0;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') ans += cnt;
                    st.pop();
                    cnt /= 3;
                }
            }
        }
        if (!st.isEmpty()) ans = 0;
        System.out.println(ans);
    }

}
