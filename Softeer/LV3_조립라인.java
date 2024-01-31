import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        int[][] B = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(i == N - 1){
                A[i][0] = Integer.parseInt(st.nextToken());
                B[i][0] = Integer.parseInt(st.nextToken());
            }else {
                A[i][0] = Integer.parseInt(st.nextToken());
                B[i][0] = Integer.parseInt(st.nextToken());
                A[i][1] = Integer.parseInt(st.nextToken());
                B[i][1] = Integer.parseInt(st.nextToken());
            }
            if(i > 0) {
                A[i][0] = Math.min(A[i - 1][0], B[i - 1][0] + B[i - 1][1]) + A[i][0];
                B[i][0] = Math.min(B[i - 1][0], A[i - 1][0] + A[i - 1][1]) + B[i][0];
            }
        }    
        System.out.println(Math.min(A[N - 1][0], B[N - 1][0]));
    }
}

