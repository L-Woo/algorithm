class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int turn = 1;
        
        while(sb.length() < t) {
            String str = Integer.toString(num++, n).toUpperCase();
            
            for(int i = 0; i < str.length() && sb.length() < t; i++) {
                if(turn == p) sb.append(str.charAt(i));
                turn = turn % m + 1;
            }
        }
        
        return sb.toString();
    }
}
