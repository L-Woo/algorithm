class Solution {
    public int[] solution(int[] prices) {
        int[] answer =  new int[prices.length];
    
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                // 1초 추가
                answer[i]++;
                // 만약 가격이 떨어진 경우라면 반복문 종료
                if(prices[i] > prices[j]) break;   
            }
        }
        
        return answer;
    }
}
