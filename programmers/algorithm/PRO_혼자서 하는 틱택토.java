class Solution {
    
    static char[][] map;
    
    public int solution(String[] board) {
        int answer = 1;
        
        int oCnt = 0;
        int xCnt = 0;
        
        map = new char[3][3];
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O')
                    oCnt++;
                if(map[i][j] == 'X')
                    xCnt++;
            }
        }
        // O가 선공이기 때문에 xCnt보다 1크거나 같아야 한다
        if(oCnt < xCnt || oCnt - xCnt > 1) answer = 0;
        // 둘 다 승리조건을 달성할 수 없다
        if(check('O') > 0 && check('X') > 0) answer = 0;
        // O가 이긴 경우 xCnt가 oCnt 같거나 클 수는 없다.
        if(check('O') > 0) {
            if(oCnt <= xCnt) answer = 0;
        }
        // X가 진 경우 oCnt가 xCnt보다 클 수 없다.
        if(check('X') > 0) {
            if(oCnt > xCnt) answer = 0;
        }

        return answer;
    }
    
    static int check(char c) {
            
        int cnt = 0;
        
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) cnt++;
            else if(map[0][i] == c && map[1][i] == c && map[2][i] == c) cnt++;
        }
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) cnt++;
        if(map[2][0] == c && map[1][1] == c && map[0][2] == c) cnt++;
        return cnt;
    }
    
}

