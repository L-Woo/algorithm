package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3 {

    static int[] arr;
    static boolean[] visited;

    static class Point {
        int idx;
        int time;

        public Point(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];

        bfs(N, K);
        System.out.println(arr[K]);
    }

    static void bfs(int n, int k) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (isValid(p.idx * 2) && (!visited[p.idx * 2] || arr[p.idx * 2] > p.time)) {
                arr[p.idx * 2] = p.time;
                visited[p.idx * 2] = true;
                queue.add(new Point(p.idx * 2, p.time));
            }

            if (isValid(p.idx + 1) && (!visited[p.idx + 1] || arr[p.idx + 1] > p.time + 1)) {
                arr[p.idx + 1] = p.time + 1;
                visited[p.idx + 1] = true;
                queue.add(new Point(p.idx + 1, p.time + 1));
            }

            if (isValid(p.idx - 1) && (!visited[p.idx - 1] || arr[p.idx - 1] > p.time + 1)) {
                arr[p.idx - 1] = p.time + 1;
                visited[p.idx - 1] = true;
                queue.add(new Point(p.idx - 1, p.time + 1));
            }
        }
    }

    static boolean isValid(int num) {
        return num >= 0 && num <= 100000;
    }
}
