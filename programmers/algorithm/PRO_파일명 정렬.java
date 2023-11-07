import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] arr = new String[files.length][3];
        
        for(int i = 0; i < files.length; i++) {
            String file = files[i];
            int endHeadIdx = 0;
            int startNumIdx = 0;
            int endNumIdx = 0;
            boolean flag = false;

            for(int j = 0; j < file.length(); j++) {
                if(Character.isDigit(file.charAt(j))) {
                    if(!flag) {
                        endHeadIdx = j;
                        startNumIdx = j;
                        flag = true;
                    }
                    endNumIdx = j;
                } else if(flag) {
                    break;
                }
            }
            
            arr[i][0] = file.substring(0, endHeadIdx);
            arr[i][1] = file.substring(startNumIdx, endNumIdx + 1);
            arr[i][2] = file.substring(endNumIdx + 1);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            int headCompare = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }
            return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
        });
        
        for(int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i][0]);
            sb.append(arr[i][1]);
            sb.append(arr[i][2]);
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
