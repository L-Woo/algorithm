class Solution {
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        
        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(true) {
            int cnt = blockCheck(m, n, map);
            if(cnt == 0) break;
            answer += cnt;
            
            blockDrop(m, n, map);
        }
        
        return answer;
    }
    // 블록 체크
    // blockCheck를 기준점에서 오른쪽, 아래, 오른쪽 아래만 고려한다.
    // 그렇기 때문에 행과 열의 마지막은 제외한다.
    int blockCheck(int m, int n, char[][] map) {
        
        boolean[][] check = new boolean[m][n];
        int cnt = 0;
        
        for(int r = 0; r < m - 1; r++) {
            for(int c = 0; c < n - 1; c++) {
                if(map[r][c] == '.') continue;
                checkBreak(check, map, r, c, map[r][c]);
            }
        }
        
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(check[r][c]) {
                    map[r][c] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    // 현 위치에서 오른쪽, 아래, 오른쪽 아래의 블록이 같은 블록인지 확인
    void checkBreak(boolean[][] check, char[][] map, int i, int j, char ch) {
        for(int r = i; r < i + 2; r++) {
            for(int c = j; c < j + 2; c++) {
                if(map[r][c] != ch) return;
            }
        }
        
        for(int r = i; r < i + 2; r++) {
            for(int c = j; c < j + 2; c++) {
                check[r][c] = true;
            }
        }
    }

    // 블록을 내리고 check에 true를 false로 변경하여 다시 검사
    void blockDrop(int m, int n, char[][] map) {
        for(int c = 0; c < n; c++) {
            for(int r = m - 1; r >= 0; r--) {
                if(map[r][c] == '.') {
                    for(int k = r - 1; k >= 0; k--) {
                        if(map[k][c] != '.') {
                            map[r][c] = map[k][c];
                            map[k][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
}
