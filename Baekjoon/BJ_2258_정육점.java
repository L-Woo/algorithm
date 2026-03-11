package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2258_정육점 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][2];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int price = Integer.parseInt(st.nextToken());

      arr[i][0] = weight;
      arr[i][1] = price;
    }

    Arrays.sort(arr, ((o1, o2) -> {
      if(o1[1] == o2[1]) {
        return o2[0] - o1[0];
      }
      return o1[1] - o2[1];
    }));

    long ans = Long.MAX_VALUE;
    int curWeight = 0;
    long totalPrice = 0;

    for(int i = 0; i < N; i++) {
      curWeight += arr[i][0];

      if(i > 0 && arr[i][1] == arr[i - 1][1]) {
        totalPrice += arr[i][1];
      }else{
        totalPrice = arr[i][1];
      }
      if(M <= curWeight) {
        ans = Math.min(ans, totalPrice);
      }

    }
    System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
  }

}
