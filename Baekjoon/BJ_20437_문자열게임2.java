import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1) {
                System.out.println(1 + " " + 1);
                continue;
            }

           int[] alpha = new int[26];

           for(int j = 0; j < str.length(); j++) {
               alpha[str.charAt(j) - 'a']++;
           }

           int max = Integer.MIN_VALUE;
           int min = Integer.MAX_VALUE;
           for(int j = 0; j < str.length(); j++) {

               int count = 1;
               if(alpha[str.charAt(j) - 'a'] < K) {
                   continue;
               }

               for(int c = j + 1; c < str.length(); c++) {
                   if(str.charAt(j) == str.charAt(c)) {
                       count++;
                   }
                   if(count == K) {
                       min = Math.min(min, c - j + 1);
                       max = Math.max(max, c - j + 1);
                       break;
                   }
               }

           }
           if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
               System.out.println(-1);
           }else {
               System.out.println(min + " " + max);
           }
        }


    }

}
