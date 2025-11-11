package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11779_최소비용구하기2 {

    static class Node {
        int idx, weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<List<Node>> graph;
    static int[] route, dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        route = new int[N + 1];
        dist = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstar(start, end);

        List<Integer> list = new ArrayList<>();
        int cur = end;
        while(cur != 0) {
            list.add(cur);
            cur = route[cur];
        }
        System.out.println(dist[end]);
        System.out.println(list.size());
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    static void dijkstar(int start, int end) {

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        route[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node cur = pq.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;
//            if(cur.idx == end) {
//                break;
//            }

            for(Node next : graph.get(cur.idx)) {
                if(!visited[next.idx] & dist[next.idx] > dist[cur.idx] + next.weight) {
                    dist[next.idx] = dist[cur.idx] + next.weight;
                    pq.add(new Node(next.idx, dist[next.idx]));
                    route[next.idx] = cur.idx;
                }
            }
        }
    }
}
