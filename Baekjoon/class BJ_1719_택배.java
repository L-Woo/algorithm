package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1719_택배 {

    static class Node {
        int idx, weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<List<Node>> graph;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, weight));
            graph.get(b).add(new Node(a, weight));
        }

        for(int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) System.out.print("- ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dijkstra(int start) {

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Node cur = pq.poll();

            if(visited[cur.idx]){
                continue;
            }
            visited[cur.idx] = true;

            for(Node next : graph.get(cur.idx)) {
                if(!visited[next.idx] && dist[next.idx] > dist[cur.idx] + next.weight) {
                    dist[next.idx] = dist[cur.idx] + next.weight;
                    pq.add(new Node(next.idx, dist[next.idx]));
                    map[next.idx][start] = cur.idx;
                }
            }
        }
    }
}
