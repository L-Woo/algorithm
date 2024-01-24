import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] weight = new int[N + 1];
        List<Integer>[] arr = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<>();
        }

        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            if(arr[i].size() == 0) {
                answer++;
                continue;
            }
            boolean flag = true;
            int curWeight = weight[i];
            for(int j = 0; j < arr[i].size(); j++) {
                if(curWeight <= weight[arr[i].get(j)]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
