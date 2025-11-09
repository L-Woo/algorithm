package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {

  int index, cost;

  public Node(int index, int cost) {
    this.index = index;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(this.cost, o.cost);
  }
}

public class BJ_1916_최소비용구하기 {

  static int N, M;
  static List<Node>[] graph;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph[from].add(new Node(to, cost));
    }

    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    
    System.out.println(dijkstra(start, end));
  }

  static int dijkstra(int start, int end) {

    boolean[] visited = new boolean[N + 1];
    int[] dist = new int[N + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();
      int idx = curNode.index;
      if(visited[end]) break;

      if(!visited[idx]) {
        visited[idx] = true;
      }

      for(Node node : graph[idx]) {
        int next = node.index;
        int cost = node.cost;

        if(!visited[next] && dist[next] > dist[idx] + cost) {
          dist[next] = dist[idx] + cost;
          pq.add(new Node(next, dist[next]));
        }
      }
    }
    return dist[end];
  }

}
