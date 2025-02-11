package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16226_거울냥이는죽어서거울을남긴다 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int[][] cats = new int[N][2];
        int R = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cats[i][0] = r;
            cats[i][1] = c;
            R = Math.max(R, r + 1);
        }

        Arrays.sort(cats, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        List<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= R; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N; i++) {
            list.get(cats[i][0]).add(new int[]{cats[i][1], 1});
            list.get(cats[i][0] + 1).add(new int[]{cats[i][1], 0});
        }
        
        for (int i = 1; i <= R; i++) {
            list.get(i).sort((o1, o2) -> o1[0] - o2[0]);
        }
        
        for (int i = 1; i <= R; i++) {
            boolean living = true;
            for (int[] arr : list.get(i)) {
                if (living && arr[1] == 1) {
                    ans++;
                    living = false;
                } else if (!living && arr[1] == 0) {
                    living = true;
                }
            }
        }
        
        System.out.println(ans);
    }

}
