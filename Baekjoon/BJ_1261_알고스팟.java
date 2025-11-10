package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1261_알고스팟 {

  static class Node {
    int r, c, cnt;

    public Node(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }


  }

  static int R, C;
  static int[][] map;
  static boolean[][] visited;
  static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    C = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    visited = new boolean[R][C];

    for(int i = 0; i < R; i++) {
      String str = br.readLine();
      for(int j = 0; j < C; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }
    bfs();

  }

  static void bfs() {

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return o1.cnt - o2.cnt;});
    pq.add(new Node(0, 0, 0));
    visited[0][0] = true;

    int nr, nc;
    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if(cur.r == R - 1 && cur.c == C - 1) {
        System.out.println(cur.cnt);
        return;
      }

      for(int d = 0; d < 4; d++) {
        nr = cur.r + dr[d];
        nc = cur.c + dc[d];

        if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
        if(!visited[nr][nc]) {
          visited[nr][nc] = true;
          if(map[nr][nc] == 1) {
            pq.add(new Node(nr, nc, cur.cnt + 1));
          }else {
            pq.add(new Node(nr, nc, cur.cnt));
          }
        }
      }
    }
  }
}
