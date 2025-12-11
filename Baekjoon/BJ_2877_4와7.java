package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2877_4와7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String str = Integer.toBinaryString(N + 1)
            .replace('0', '4')
            .replace('1', '7');
        for(int i = 1; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
    }
}
