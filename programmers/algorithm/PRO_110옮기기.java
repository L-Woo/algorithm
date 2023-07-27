import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++) {
            
            Stack<Character> st = new Stack<>();
            String str = s[i];
            
            int cnt = 0;
            
            for(int j = 0; j < str.length(); j++) {
                
                char third = str.charAt(j);
                
                if(st.size() > 1) {
                    
                    char second = st.pop();
                    char first = st.pop();
                    
                    if(first == '1' && second == '1' && third == '0') {
                        cnt++;
                    }else {
                        st.push(first);
                        st.push(second);
                        st.push(third);
                    }
                        
                }else {
                    st.push(third);
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            int idx = st.size();
            boolean flag = true;
            
            while(!st.isEmpty()) {
                if(flag){
                    if(st.peek() == '1') 
                        idx--;
                    else
                        flag = false;
                }
                sb.insert(0, st.pop());
            }
           
            
            if(idx == -1) {
                sb.insert(0, 110);
            }else {
                while(cnt > 0) {
                    sb.insert(idx, 110);
                    cnt--;
                }
            }
            
            answer[i] = sb.toString();
            
        }
        
        return answer;
    }
}
