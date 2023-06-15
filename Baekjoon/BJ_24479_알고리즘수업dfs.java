import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_24479_알고리즘수업dfs {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int order;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int node = Integer.parseInt(st.nextToken());

        check = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        order = 1;

        dfs(node);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int node) {
        check[node] = order;

        for(int i = 0; i < graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);

            if(check[newNode] == 0) {
                order++;
                dfs(newNode);
            }
        }
    }

}
