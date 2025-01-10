package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_2866_문자열잘라내기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int left = 0;
        int right = R - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            HashSet<String> set = new HashSet<>();
            for (int c = 0; c < C; c++) {
                StringBuilder sb = new StringBuilder();
                for (int r = mid + 1; r < R; r++) {
                    sb.append(arr[r][c]);
                }
                if (set.contains(sb.toString())) {
                    break;
                }
                set.add(sb.toString());
            }
            if (set.size() == C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

}
