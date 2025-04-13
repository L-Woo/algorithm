package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1491_나선 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;
        int left = 0, right = N - 1;
        int bottom = 0, top = M - 1;
        int dir = 0;

        while (true) {
            if (dir == 0) {
                x = right;
                y = bottom;
                bottom++;
                if (bottom > top) break;
            } else if (dir == 1) {
                y = top;
                x = right;
                right--;
                if (left > right) break;
            } else if (dir == 2) {
                x = left;
                y = top;
                top--;
                if (bottom > top) break;
            } else if (dir == 3) {
                y = bottom;
                x = left;
                left++;
                if (left > right) break;
            }

            dir = (dir + 1) % 4;
        }
        System.out.println(x + " " + y);
    }
}
