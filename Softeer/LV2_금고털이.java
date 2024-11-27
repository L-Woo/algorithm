import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
           return o2[1] - o1[1];
        });

        int idx = 0;
        while(W > 0) {
            if(W >= arr[idx][0]) {
                ans += arr[idx][1] * arr[idx][0];
                W -= arr[idx][0];
            }else {
                ans += arr[idx][1] * W;
                W -= W;
            }
            idx++;
        }
        System.out.println(ans);
    }
}
