package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10282_해킹 {

    static class Computer {
        int idx, weight;

        public Computer(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
    static List<List<Computer>> graph;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList());
            }

            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Computer(end, weight));
            }
            dijkstra(c);
        }
    }

    static void dijkstra(int start) {

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Computer> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Computer(start, 0));

        while(!pq.isEmpty()) {
            Computer cur = pq.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;

            for(Computer next : graph.get(cur.idx)) {
                if(!visited[next.idx] && dist[next.idx] > dist[cur.idx] + next.weight) {
                    dist[next.idx] = dist[cur.idx] + next.weight;
                    pq.add(new Computer(next.idx, dist[next.idx]));
                }
            }
        }

        int cnt = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] != Integer.MAX_VALUE) {
                cnt++;
                ans = Math.max(ans, dist[i]);
            }
        }
        System.out.println(cnt + " " + ans);
    }

}
