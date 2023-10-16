class Solution {
    
    static int[] arr;
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        arr = new int[n];
        dfs(0, n);
        return answer;
    }
    
    void dfs(int depth, int n) {
        if(depth == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            arr[depth] = i;
            if(check(depth)) dfs(depth + 1, n);
        }
    }
    
    boolean check(int row) {
        for(int i = 0; i < row; i++) {
            if(arr[i] == arr[row]) return false;
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }
}
