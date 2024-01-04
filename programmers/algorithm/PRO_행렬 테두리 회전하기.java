class Solution {
    
    static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows + 1][columns + 1];
        int num = 1;
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }
        
        return answer;
    }
    
    static int rotation(int[] arr) {
        int x1 = arr[0];
        int y1 = arr[1];
        int x2 = arr[2];
        int y2 = arr[3];
        int temp = map[x1][y2];
        int min = map[x1][y2];
        
        for(int i = y2; i > y1; i--) {
            min = Math.min(min, map[x1][i - 1]);
            map[x1][i] = map[x1][i - 1];
        }
        
        for(int i = x1; i < x2; i++) {
            min = Math.min(min, map[i + 1][y1]);
            map[i][y1] = map[i + 1][y1];
        }
        
        for(int i = y1; i < y2; i++) {
            min = Math.min(min, map[x2][i + 1]);
            map[x2][i] = map[x2][i + 1];
        }
        
        for(int i = x2; i > x1 + 1; i--) {
            min = Math.min(min, map[i - 1][y2]);
            map[i][y2] = map[i - 1][y2];
        }
        
        map[x1 + 1][y2] = temp;
        
        return min;
    }

}
