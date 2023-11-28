import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        
        int[][] arr = new int[2][2];
        
        for(char ch : dirs.toCharArray()) {
            boolean flag = true;
            arr[0][0] = arr[1][0];
            arr[0][1] = arr[1][1];
            switch(ch) {
                case 'U':
                    arr[1][0] -= 1;
                    if(arr[1][0] < -5) {
                        arr[1][0] = -5;
                        flag = false;
                    }
                    break;
                    
                case 'D' :
                    arr[1][0] += 1;
                    
                    if(arr[1][0] > 5) {
                        arr[1][0] = 5;
                        flag = false;
                    }
                    break;
                    
                case 'R' :
                    arr[1][1] += 1;
                    
                    if(arr[1][1] > 5) {
                        arr[1][1] = 5;
                        flag = false;
                    }
                    break;
                    
                case 'L' :
                    arr[1][1] -= 1;
                    
                    if(arr[1][1] < -5) {
                        arr[1][1] = -5;
                        flag = false;
                    }
                    break;
            }
            
            
            if(flag) {
                set.add("" + arr[0][0] + arr[0][1] + arr[1][0] + arr[1][1]);
			    set.add("" + arr[1][0] + arr[1][1] + arr[0][0] + arr[0][1]);
            }
            
        }
        answer =set.size() / 2;
        
        return answer;
    }
}
