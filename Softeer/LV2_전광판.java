import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Character, int[]> map = new HashMap<>();
        map.put('0', new int[] {1, 1, 1, 0, 1, 1, 1});
        map.put('1', new int[] {0, 0, 1, 0, 0, 1, 0});
        map.put('2', new int[] {1, 0, 1, 1, 1, 0, 1});
        map.put('3', new int[] {1, 0, 1, 1, 0, 1, 1});
        map.put('4', new int[] {0, 1, 1, 1, 0, 1, 0});
        map.put('5', new int[] {1, 1, 0, 1, 0, 1, 1});
        map.put('6', new int[] {1, 1, 0, 1, 1, 1, 1});
        map.put('7', new int[] {1, 1, 1, 0, 0, 1, 0});
        map.put('8', new int[] {1, 1, 1, 1, 1, 1, 1});
        map.put('9', new int[] {1, 1, 1, 1, 0, 1, 1});
        map.put(' ', new int[] {0, 0, 0, 0, 0, 0, 0});

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            String cur = String.format("%5s", st.nextToken());
            String target = String.format("%5s", st.nextToken());

            for(int i = 0; i < cur.length(); i++) {
                if(cur.charAt(i) != target.charAt(i)) {
                    int[] curArr = map.get(cur.charAt(i));
                    int[] targetArr = map.get(target.charAt(i));

                    for(int j = 0; j < 7; j++) {
                        if(curArr[j] != targetArr[j]) cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
