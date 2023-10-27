import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long K;
    static List<List<Integer>> graph;
    static int[] indegree;
    static long[] requestCount;

    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        graph = new ArrayList<>();
        indegree = new int[N + 1];
        requestCount = new long[N + 1];

        requestCount[1] = K;

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            for(int j = 0; j < n; j++) {
                int next = Integer.parseInt(st.nextToken());
                indegree[next]++;
                graph.get(i).add(next);
            }
        }

        topologicalSort();

        for(int i = 1; i < requestCount.length; i++) {
            System.out.print(requestCount[i] + " ");
        }

    }

    public static void topologicalSort() {
       
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            
            int cur = q.poll();
            List<Integer> list = graph.get(cur);
        
            for(int i = 0; i < list.size(); i++) {
                
                int next = list.get(i);
                
                requestCount[next] += requestCount[cur] / list.size();

                if(i < requestCount[cur] % list.size()) {
                    requestCount[next]++;
                }

                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }

            }

        }

    }
}
