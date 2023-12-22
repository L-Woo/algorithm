class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            answer[1] -= s.length();
            s = Integer.toString(s.length(), 2);
            answer[0]++;
        }
        
        return answer;
    }
}
