import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        HashSet<Integer> set = new HashSet<>();
        String str = s.substring(2, s.length() - 2);
        str = str.replace("},{", "-");
        String[] arr = str.split("-");
        
        
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        int[] answer = new int[arr.length];
        
        int idx = 0;
        
        for(String num : arr) {
            StringTokenizer st = new StringTokenizer(num, ",");
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if(set.add(temp)) answer[idx++] = temp;
            }
        }
        
        return answer;
    }
}
