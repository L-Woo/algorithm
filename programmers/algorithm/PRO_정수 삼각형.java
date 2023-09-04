class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i - 1].length; j++) {
                for(int k = j; k <= j + 1; k++) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + triangle[i][k]);
                }
            }
        }
        
        for(int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);    
        }
        
        return answer;
    }
}
