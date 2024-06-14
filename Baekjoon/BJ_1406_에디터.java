package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1406_에디터 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int idx = sb.length();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) leftStack.add(str.charAt(i));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char commnad = st.nextToken().charAt(0);
            if (commnad == 'L') {
                if (!leftStack.isEmpty()) rightStack.add(leftStack.pop());
            } else if (commnad == 'D') {
                if (!rightStack.isEmpty()) leftStack.add(rightStack.pop());
            } else if (commnad == 'B') {
                if (!leftStack.isEmpty()) leftStack.pop();
            } else if (commnad == 'P') {
                char ch = st.nextToken().charAt(0);
                leftStack.add(ch);
            }
        }
        while (!leftStack.isEmpty()) rightStack.add(leftStack.pop());
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());

        System.out.println(sb.toString());
    }

}
