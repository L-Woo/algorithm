package baekjoon;package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4659_비밀번호발음하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean flag = false;
            char prev = ' ';
            int cnt = 0;

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(gatherCheck(ch)) flag = true;
                if(gatherCheck(prev) == gatherCheck(ch)) cnt++;
                else cnt = 1;
                if(cnt > 2 || (prev == ch && (ch != 'o' && ch != 'e'))) {
                    flag = false;
                    break;
                }
                prev = ch;
            }

            if(flag) System.out.println("<" + str + ">" + " is acceptable.");
            else System.out.println("<" + str + ">" + " is not acceptable.");


        }

    }

    static boolean gatherCheck(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
