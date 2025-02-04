package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13335_트럭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int curWeight = 0;
        int time = 0;
        Queue<Integer> truck = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            curWeight -= bridge.poll();

            if (truck.isEmpty()) {
                continue;
            }

            if (truck.peek() + curWeight <= L) {
                int weight = truck.poll();
                bridge.add(weight);
                curWeight += weight;
            } else {
                bridge.add(0);
            }
        }
        System.out.println(time);
    }
}
