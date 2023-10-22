import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
    
        List<String> list = new ArrayList<>();
        char prev = words[0].charAt(0);

        for(int i = 0; i < words.length; i++) {
            if(list.contains(words[i]) || words[i].charAt(0) != prev) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            else {
                list.add(words[i]);
                prev = words[i].charAt(words[i].length() - 1);
            }
        }

        return answer;
    }
}
