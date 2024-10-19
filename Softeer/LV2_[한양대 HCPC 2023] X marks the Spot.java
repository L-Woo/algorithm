import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String S = st.nextToken();
            String T = st.nextToken();    
            int idx = S.indexOf('X');

            if(idx == -1) idx = S.indexOf('x');
            
            sb.append(T.charAt(idx));
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
