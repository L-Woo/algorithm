import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXY{
    int row;
    int col;

    public PointXY(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int rowArr[] = {-1, 1, 0, 0};
    static int colArr[] = {0, 0, -1, 1};
    static int m, n;
    static int arr[][];
    static Queue<PointXY> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
      

        arr = new int[n + 1][m + 1];

     
            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) queue.add(new PointXY(i, j));
                }
            }
        

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            PointXY point = queue.poll();
            
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 4; i++){
                int moveRow = row + rowArr[i];
                int moveCol = col + colArr[i];
                
                if(checkPoint(moveRow, moveCol)){
                    queue.add(new PointXY(moveRow, moveCol));
                    arr[moveRow][moveCol] = arr[row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(arr[i][j] == 0) {
                    	return -1;
                    }
                    result = Math.max(result, arr[i][j]);
                }
            }
        
        if(result == 1) {
        	return 0;
        }
        else {
        	return (result - 1);
        }
    }

    private static boolean checkPoint(int row, int col){
    	
        if(row < 1 || row > n || col < 1 || col > m) {
        	return false;
        }
        if(arr[row][col] == 0) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
