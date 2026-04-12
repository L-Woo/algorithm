package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9996_한국이그리울땐서버에접속하지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split("\\*");
        int len = arr[0].length() + arr[1].length();

        for(int i = 0; i < N; i++) {
            String target = br.readLine();
            boolean flag = false;
            if(target.length() >= len) {
                if(target.substring(0, arr[0].length()).equals(arr[0]) &&
                    (target.substring(target.length() - arr[1].length()).equals(arr[1]))) {
                    flag = true;

                }
            }
            if(flag) {
                sb.append("DA").append("\n");
            }else {
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
