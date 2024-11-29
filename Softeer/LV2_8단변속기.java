import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        boolean flag = true;
        
        for(int i = 0; i < 8; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 7; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if(diff != 1) {
                flag = false;
                break;
            }
        }

        if(!flag) System.out.println("mixed");
        else {
            if(arr[0] == 1) System.out.println("ascending");
            else if(arr[0] == 8) System.out.println("descending");
        }
    }
}
