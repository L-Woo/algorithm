class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt = Integer.bitCount(n);
        
        while(true) {
            n += 1;
            int temp = Integer.bitCount(n);
            if(temp == cnt) break;
        }
        
        return n;
    }
}
