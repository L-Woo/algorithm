import java.util.*;

class Solution {
    
    static long answer = 0;
    static String[] op = {"+", "-", "*"};
    static String[] out = new String[3];
    static boolean[] check = new boolean[3];
    static List<String> list = new ArrayList<String>();
    
    public long solution(String expression) {
        
        
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(expression.substring(idx, i)); 
                list.add(expression.charAt(i) + ""); 
                idx = i + 1;
            }
        }
        
        list.add(expression.substring(idx));
        
        perm(0);
        
        return answer;
    }
    
    static void perm(int depth) {
        
        if(depth == 3) {
            func();
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(!check[i]) {
                check[i] = true;
                out[depth] = op[i];
                perm(depth + 1);
                check[i] = false;
            }
        } 
    }
    
    static void func() {
        List<String> temp = new ArrayList<>(list);
        
        for(int j = 0; j < out.length; j++) {
            for(int i = 0; i < temp.size(); i++) {
                if(temp.get(i).equals(out[j])) {
                    long x = Long.parseLong(temp.get(i - 1));
                    long y = Long.parseLong(temp.get(i + 1));
                    long z = 0;
                    if(out[j].equals("+")) {
                        z = x + y;
                    }else if(out[j].equals("-")) {
                        z = x - y;
                    }else if(out[j].equals("*")) {
                        z = x * y;
                    }
                    temp.set(i - 1, String.valueOf(z));
                    temp.remove(i);
                    temp.remove(i);
                    i--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
    }
    
}
