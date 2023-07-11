import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int map[] = new int[101];
	static int ladderAndSnake[] = new int[101];
	static boolean visit[] = new boolean[101];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < ladder + snake; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ladderAndSnake[a] = b;
		}
		
		bfs();
		
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			if(current == 100) {
				System.out.println(map[100]);
			}
			
			for(int i = 1; i < 7; i++) {
				
				int x = current + i;
				
				if(x > 100) {
					continue;
				}
				
				if(visit[x]) {
					continue;
				}
				
				visit[x] = true;
				
				if(ladderAndSnake[x] != 0) {
					if(!visit[ladderAndSnake[x]]) {
						q.add(ladderAndSnake[x]);
						visit[ladderAndSnake[x]] = true;
						map[ladderAndSnake[x]] = map[current] + 1;
					}
				}else {
					q.add(x);
					map[x] = map[current] + 1;
				}
			}
		}
	}

}
