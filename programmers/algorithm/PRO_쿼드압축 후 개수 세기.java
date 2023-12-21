class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        int n = arr.length;
        
        divide(arr, 0, 0, n);
        
        return answer;
    }
    
    static void divide(int[][] arr, int r, int c, int n) {
        
        if(conquer(arr, r, c, n)) {
            if(arr[r][c] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        
        divide(arr, r, c, n / 2);
        divide(arr, r, c + n / 2, n / 2);
        divide(arr, r + n / 2, c, n / 2);
        divide(arr, r + n / 2, c + n / 2, n / 2);
        
    }
    
    static boolean conquer(int[][] arr, int r, int c, int n) {
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                if(arr[r][c] != arr[i][j]) return false;
            }
        }
        return true;
    }
}
