import java.io.*;
import java.util.*;

public class Main {
    static int H, K, R;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int N = (int) Math.pow(2, H + 1) - 1; 
        int leaf = (int) Math.pow(2, H) - 1; 

        Queue<Integer>[][] task = new Queue[N][2]; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                task[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = leaf; i <= leaf * 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                task[i][0].offer(Integer.parseInt(st.nextToken()));
            }
        }

        int ans = 0;
        for (int day = 1; day <= R; day++) {
            int num = (day + 1) % 2;

            if (!task[0][num].isEmpty()) {
                ans += task[0][num].poll();
            }

            for (int i = 1; i < leaf; i++) {
                int parent = (i - 1) / 2;

                if (!task[i][num].isEmpty()) {
                    task[parent][(i + 1) % 2].offer(task[i][num].poll());
                }
            }

            for (int i = leaf; i <= leaf * 2; i++) {
                int parent = (i - 1) / 2;

                if (!task[i][0].isEmpty()) {
                    task[parent][(i + 1) % 2].offer(task[i][0].poll());
                }
            }
        }

        System.out.println(ans);
    }
}
