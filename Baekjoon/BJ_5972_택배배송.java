package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_5972_택배배송 {

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[idx1].add(new Node(idx2, cost));
            graph[idx2].add(new Node(idx1, cost));
        }
        dijkstra(1, N);
        System.out.println(dist[N]);
    }

    static void dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int curIdx = pq.poll().idx;

            if (visited[curIdx]) continue;
            visited[curIdx] = true;

            for (Node next : graph[curIdx]) {
                if (dist[next.idx] > dist[curIdx] + next.cost) {
                    dist[next.idx] = dist[curIdx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

    }

}
