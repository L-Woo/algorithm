import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;

        boolean[] visited = new boolean[N];
        char[] arr = new char[N];

        String str = br.readLine();
        
        for(int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }

        for(int i = 0; i < N; i++) {
            if(arr[i] == 'P') {
                int start = i - K < 0 ? 0 : i - K;
                int end = i + K >= N ? N - 1 : i + K;
                for(int j = start; j <= end; j++) {
                    if(arr[j] == 'H' && !visited[j]) {
                        visited[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
