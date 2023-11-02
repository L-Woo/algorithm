import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());

      int[] arr = new int[n];
    
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr);

      for(int i = 0; i < q; i++) {
        int num = Integer.parseInt(br.readLine());
        if(arr[n - 1] <= num || arr[0] >= num) {
          System.out.println(0);
          continue;
        }

        // 이분 탐색으로 num의 위치 찾기
        int idx = -1;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        
        while(left <= right) {
          mid = (left + right) / 2;          
          if(num == arr[mid]) {
            idx = mid;
            break;
          }else if(num > arr[mid]) {
            left = mid + 1;
          }else {
            right = mid - 1;
          }
        }

        System.out.println(idx != -1 ? idx * (n - (idx + 1)) : 0);
        
      }
      
    }
}
