import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(String s) {
        
        for(int i = 0; i < s.length(); i++) {
            
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(i, s.length()));
            sb.append(s.substring(0, i));
            check(sb.toString());
            
        }
        
        return answer;
    }
    
    static void check(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            
            if (st.isEmpty()) {
                st.push(ch);
            } else if (ch == ')' && st.peek() == '(') {
                st.pop();
            } else if (ch == '}' && st.peek() == '{') {
                st.pop();
            } else if (ch == ']' && st.peek() == '[') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        if(st.size() == 0) answer++;
    }
}
