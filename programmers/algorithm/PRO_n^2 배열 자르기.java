class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left + 1);  
        int[] answer = new int[length];
        
        int curR = (int)(left / n);  
        int curC = (int)(left % n); 

        for(int i = 0; i < length; i++) {
            answer[i] = Math.max(curR + 1, curC + 1); 

            if(curC + 1 >= n) {  
                curR++;
                curC = 0;
            } else curC++;
        }
        
        return answer;
    }
}
