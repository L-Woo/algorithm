package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_25556_포스택 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Stack<Integer>> stackList = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            stackList.add(new Stack<>());
            stackList.get(i).add(0);
        }
        boolean flag = true;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            boolean check = false;
            for(Stack<Integer> stack : stackList) {
                if(stack.peek() < num) {
                    stack.push(num);
                    check = true;
                    break;
                }
            }
            if(!check) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

}
