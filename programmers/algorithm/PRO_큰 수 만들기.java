import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = number.toCharArray();
        int len = number.length() - k;
        int idx = 0;
        
        for(int i = 0; i < len; i++) {
            char ch = '0';
            for(int j = idx; j <= i + k; j++) {
                if(arr[j] > ch) {
                    ch = arr[j];
                    idx = j + 1;
                }
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
