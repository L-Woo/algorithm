class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int R = board.length;
        int C= board[0].length;
        
        if(R < 2 || C < 2){
            return 1;
        }
        
        for(int i = 1; i < R; i++){
            for(int j = 1; j < C; j++){
                if(board[i][j] !=0){                
                    board[i][j] = Math.min(board[i - 1][j - 1],Math.min(board[i - 1][j],board[i][j - 1]))+1;
                }                
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}
