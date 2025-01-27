import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.contains(".")) {
                st = new StringTokenizer(str, ".");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }else {
                arr[i][0] = Integer.parseInt(str);
                arr[i][1] = -1;
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
           if(o1[0] == o2[0]) {
               return o1[1] - o2[1]; 
           } 
            return o1[0] - o2[0];
        });
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i][0]);
            if(arr[i][1] == -1) {
                System.out.println();
                continue;
            }
            System.out.println("." + arr[i][1]);
        }
    }
}
