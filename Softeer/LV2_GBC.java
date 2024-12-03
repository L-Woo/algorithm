import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        int idx = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for(int j = idx + 1; j <= len + idx; j++) arr[j] = s;
            idx += len;
        }
        
        idx = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            for(int j = idx + 1; j <= len + idx; j++) arr[j] = s - arr[j];
            idx += len;
        }
        arr[0] = 0; 
        Arrays.sort(arr);
        System.out.println(arr[100]);
    }
}
