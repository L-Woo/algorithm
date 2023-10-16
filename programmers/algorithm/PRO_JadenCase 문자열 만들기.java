class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ' ') sb.append(" ");
            else if(i > 0 && s.charAt(i - 1) == ' ') sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
