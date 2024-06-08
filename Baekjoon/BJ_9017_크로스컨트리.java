package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9017_크로스컨트리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int ans = 0;
            int[] rank = new int[N + 1];
            int[] team = new int[201];
            List<Integer>[] list = new ArrayList[200 + 1];
            HashMap<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) team[rank[i]]++;

            for (int i = 1; i <= 200; i++) {
                if (team[i] >= 6) {
                    list[i] = new ArrayList<>();
                    map.put(i, 0);
                }
            }

            int cur = 1;
            for (int i = 1; i <= N; i++) {
                if (team[rank[i]] < 6) continue;
                list[rank[i]].add(cur++);
            }

            for (int i = 1; i <= 200; i++) {
                if (team[i] >= 6) {
                    for (int j = 0; j < 4; j++) {
                        map.put(i, map.get(i) + list[i].get(j));
                    }
                }
            }

            for (int k : map.keySet()) {
                int sum = map.get(k);
                if (min > sum) {
                    min = sum;
                    ans = k;
                } else if (min == sum) {
                    if (list[ans].get(4) > list[k].get(4)) {
                        ans = k;
                    }
                }
            }

            System.out.println(ans);
        }

    }

}
