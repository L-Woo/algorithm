import java.io.*;
import java.util.*;

public class Main {

    static class Score {
      int idx, score;
      public Score(int idx, int score) {
        this.idx = idx;
        this.score = score;
      }
    }

    public static void main(String[] args)  throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int N = Integer.parseInt(br.readLine());
      Score[][] arr = new Score[4][N];

      for(int i = 0; i < 3; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
          int idx = j;
          int score = Integer.parseInt(st.nextToken());
          arr[i][j] = new Score(idx, score);
        }
      }

      for(int i = 0; i < N; i++) {
        int sum = 0;
        for(int j = 0; j < 3; j++) {
          sum += arr[j][i].score;
        }
        arr[3][i] = new Score(i, sum); 
      }

      for(Score[] soc : arr){
            Arrays.sort(soc, (o1, o2) -> o2.score - o1.score);
      }

      int[][] ans = new int[4][N];
        for(int i = 0; i < 4; i++){
            int rank = 1;
            int cnt = 1;
            ans[i][arr[i][0].idx] = rank;
            for(int j = 1; j < N; j++){
                if(arr[i][j - 1].score == arr[i][j].score){
                    ans[i][arr[i][j].idx] = rank;
                    cnt++;
                }
                else {
                    rank += cnt;
                    ans[i][arr[i][j].idx] = rank;
                    cnt = 1;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
          for(int j = 0; j < N; j++) {
            System.out.print(ans[i][j] + " ");
          }
          System.out.println();
        }
    }
}
