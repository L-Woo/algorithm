package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14676_영우는사기꾼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            inDegree[v]++;
        }

        int[] count = new int[N + 1];
        boolean isLier = false;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (type == 1) {
                if (inDegree[a] > 0) {
                    isLier = true;
                    break;
                }
                count[a]++;
                if (count[a] == 1) {
                    for (int next : list[a]) {
                        inDegree[next]--;
                    }
                }
            } else {
                if (count[a] <= 0) {
                    isLier = true;
                    break;
                }
                count[a]--;
                if (count[a] == 0) {
                    for (int next : list[a]) {
                        inDegree[next]++;
                    }
                }
            }
        }

        if (isLier) {
            System.out.println("Lier!");
        } else {
            System.out.println("King-God-Emperor");
        }
    }
}
