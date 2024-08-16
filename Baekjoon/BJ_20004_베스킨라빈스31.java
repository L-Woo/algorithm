package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20004_베스킨라빈스31 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        for(int i = 1; i <= A; i++) {
            if(30 % (i + 1) == 0) System.out.println(i);;
        }
    }

}
