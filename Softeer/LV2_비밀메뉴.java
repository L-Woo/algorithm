import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String target = br.readLine().replaceAll(" ", "");
        String cur = br.readLine().replaceAll(" ", "");

        if(N < M) System.out.println("normal");   
        else {
            String str = cur.replaceAll(target, "");
            if(str.length() < N) System.out.println("secret");
            else System.out.println("normal");
        }
    }
}
