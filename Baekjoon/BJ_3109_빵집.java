import java.io.*;
import java.util.*;

public class Main {
	
	static int r, c;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
				
		}
		
		for(int i = 0; i < r; i++) {
			if(check(i, 0)) {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static boolean check(int x, int y) {
		map[x][y] = 'x';
		
		if(y == c - 1) {	// 마지막열에 도착했으면 파이프를 연결했기 때문에 종료
			return true;
		}
		if(x - 1 >= 0 && map[x - 1][y + 1] == '.') { // 오른쪽 위에 탐색
			 if(check(x - 1, y + 1)) {
				 return true;
			 }
		}
		if(map[x][y + 1] == '.') {	// 오른쪽 탐색
			if(check(x, y + 1)) {
				return true;
			}
		}
		if(x + 1 < r && map[x + 1][y + 1] == '.') { // 오른쪽 아래 탐색
			if(check(x + 1, y + 1))	{
				return true;
			}
		}
		
		return false;
	}
	
}
