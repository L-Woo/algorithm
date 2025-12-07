package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3097_산책경로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        int[] xs = new int[n];
        int[] ys = new int[n];

        int sumX = 0; 
        int sumY = 0; 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xs[i] = x;
            ys[i] = y;

            sumX += x;
            sumY += y;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sumX).append(" ").append(sumY).append("\n");

        double minDist = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int nx = sumX - xs[i]; 
            int ny = sumY - ys[i]; 

            // 거리 = sqrt(nx^2 + ny^2)
            double dist = Math.sqrt((double) nx * nx + (double) ny * ny);

            if (dist < minDist) {
                minDist = dist;
            }
        }
      
        sb.append(String.format("%.2f", minDist));

        System.out.println(sb.toString());
    }
}
