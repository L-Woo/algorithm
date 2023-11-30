import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        if (p.isEmpty()) {
            return p;
        }

        int idx = 0;
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') { 
                left++;
            } else {
                right++;
            }
            if(right == left) {
                idx = i;
                break;
            }
        }
        
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        
        if (check(u)) {
            return u + solution(v);
        }
        return "(" + solution(v) + ")" + change(u);
    }
                         
    static String change(String u) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
    
    static boolean check(String u) {
        
        int left = 1;
        
        if(u.charAt(0) != '(') return false;
        
        for(int i = 1; i < u.length(); i++) {
            if(u.charAt(i) == '(') left++;
            else left--;
            
            if(left < 0) {
                return false;
            }
        }
        return true;
    }
    
}
