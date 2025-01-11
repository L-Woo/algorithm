package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_17264_IAMIRONMAN {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int score = 0;

        st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (!map.containsKey(str)) {
                score -= L;
            } else {
                String cur = map.get(str);
                if (cur.equals("W")) {
                    score += W;
                } else {
                    score -= L;
                }
            }
            if (score < 0) score = 0;
            if (score >= G) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}
