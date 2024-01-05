class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            }else {
                StringBuilder sb = new StringBuilder(Long.toString(numbers[i], 2));
                if(sb.toString().contains("01")) {
                    for(int j = sb.length(); j > 0; j--) {
                        if(sb.substring(j - 2, j).equals("01")) {
                            sb.setCharAt(j - 1, '0');
                            sb.setCharAt(j - 2, '1');
                            break;
                        }
                    }
                }else {
                    sb.deleteCharAt(0);
                    sb.insert(0, "10");
                }
                answer[i] = Long.valueOf(sb.toString(), 2);
            }
        }
        
        return answer;
    }
}
