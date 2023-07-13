// 0, 1, 2으로만 숫자를 만든다.
// 0으로 시작하는 수를 만들 수 없다.
// 1 <= N <= 9
// N = 1일 때
// 1, 2
// N = 2일 때
// 10, 11, 12
// 20, 21, 22
// 3의 배수는 21, 12

// N = 1일 때의 수에서 0, 1, 2로 수를 만들기 때문에 3을 곱한 수가 다음 전체 수 이다.
// 3의 배수를 확인하기 위해서 숫자의 각 자릿수를 모두 더 한 값에서 3을 나눈 나머지가 0이면 3의 배수이다
// ex) 1013 -> 5 % 3 = 2 X / 1012 -> 4 % 3 = 1 X / 1011 -> 3 % 3 = 0 O
// 0, 1, 2의 수로 만 숫자를 만들기 때문에 만들어진 숫자에서 다음 자릿수 3개가 만들어지고 그 중에 한개는 3의 배수이다.
// dp[i] = dp[i - 1] * 3이 성립한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10];

        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] * 3;
        }

        System.out.println(dp[N]);

    }

}
