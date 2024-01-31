import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int ans = 1;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        int prev = arr[0][1];
        for(int i = 1; i < N; i++) {
            if(arr[i][0] >= prev) {
                prev = arr[i][1];
                ans++;
            }
        }

        System.out.println(ans);
    }
}
