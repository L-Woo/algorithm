package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3190_뱀 {

  static int N, K, L;
  static int[][] map;
  static Map<Integer, String> moveInfo = new HashMap<>();
  static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    map = new int[N + 1][N + 1];

    StringTokenizer st;
    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map[r][c] = 1;
    }

    L = Integer.parseInt(br.readLine());
    for(int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      String C = st.nextToken();
      moveInfo.put(X, C);
    }
    solve();
  }

  static void solve() {
    Deque<int[]> snake = new ArrayDeque<>();
    snake.addFirst(new int[]{1,1});
    map[1][1] = 2;

    int time = 0;
    int d = 0;
    int curR = 1, curC = 1;

    while(true) {

      time++;

      int nr = curR + dr[d];
      int nc = curC + dc[d];

      if(nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 2) {
        System.out.println(time);
        break;
      }

      if(map[nr][nc] == 1) {
        map[nr][nc] = 2;
        snake.addFirst(new int[]{nr, nc});
      }else {
        map[nr][nc] = 2;
        snake.addFirst(new int[]{nr, nc});
        int[] tail = snake.removeLast();
        map[tail[0]][tail[1]] = 0;
      }
      curR = nr;
      curC = nc;

      if(moveInfo.containsKey(time)) {
        String dir = moveInfo.get(time);
        if(dir.equals("D")) {
          d = (d + 1) % 4;
        }else {
          d = (d + 3) % 4;
        }
      }
    }
  }

}
