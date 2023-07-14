import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int ans;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j], visit);
				visit[i][j] = false;
				check(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int cnt, int sum, boolean[][] visit) {
		if(cnt >= 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) {
				continue;
			}
			
			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1, sum + map[ny][nx], visit);
			visit[ny][nx] = false;
		}
	}
	
	static void check(int y, int x) {
		if(y < n - 2 && x < m -1) {
			ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
		}
		if(y < n - 2 && x > 0) {
			ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);
		}
		if(y < n - 1 && x < m -2) {
			ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
		}
		if(y > 0 && x < m -2) {
			ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
		}
	}

}
