package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427_소트인사이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[str.length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

}
