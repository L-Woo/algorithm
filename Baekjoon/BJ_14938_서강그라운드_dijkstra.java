package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14938_서강그라운드_dijkstra {

  static class Field{
    int idx, weight;

    public Field(int idx, int weight) {
      this.idx = idx;
      this.weight = weight;
    }
  }

  static int n, m, r;
  static int[] item;
  static List<List<Field>> graph;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();

    for(int i = 0; i <= n; i++) {
     graph.add(new ArrayList<>());
    }
    item = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= n; i++) {
      item[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Field(to, weight));
      graph.get(to).add(new Field(from, weight));
    }
    int ans = 0;
    for(int i = 1; i <= n; i++) {
      ans = Math.max(ans, dijkstra(i));
    }
    System.out.println(ans);
  }

  static int dijkstra(int start) {

    int[] dist = new int[n + 1];
    boolean[] visited = new boolean[n + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<Field> pq = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
    pq.add(new Field(start, 0));

    while(!pq.isEmpty()) {

      Field cur = pq.poll();

      if(!visited[cur.idx]) {
        visited[cur.idx] = true;
      }

      for(Field field : graph.get(cur.idx)) {
        if(!visited[field.idx] && dist[field.idx] > dist[cur.idx] + field.weight) {
          dist[field.idx] = dist[cur.idx] + field.weight;
          pq.add(new Field(field.idx, dist[field.idx]));
        }
      }
    }

    int cnt = 0;
    for(int i = 1; i <= n; i++) {
      if(dist[i] <= m) {
        cnt += item[i];
      }
    }

    return cnt;
  }

}
