package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_1939_중량제한 {

    static class Island{
        int idx, weight;
        public Island(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<List<Island>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i= 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Island(b, weight));
            graph.get(b).add(new Island(a, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));

    }

    static int dijkstra(int start, int end) {

        int[] weight = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(weight, 0);

        PriorityQueue<Island> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.weight, o1.weight)
        );

        weight[start] = Integer.MAX_VALUE;
        pq.add(new Island(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Island cur = pq.poll();

            if (visited[cur.idx]) continue;
            visited[cur.idx] = true;

            if (cur.idx == end) return cur.weight;

            for (Island next : graph.get(cur.idx)) {
                int possible = Math.min(cur.weight, next.weight);
                if (possible > weight[next.idx]) {
                    weight[next.idx] = possible;
                    pq.add(new Island(next.idx, possible));
                }
            }
        }
        return weight[end];
    }
}
