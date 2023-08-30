// begin 단어에서 target 단어로 변환하는 가장 짧은 변환 과정을 찾는다.
// 1. 한 번에 한 개의 알파벳만 바꿀 수 있다.
// 2. words에 있는 단어로만 변환할 수 있다.


class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    void dfs(String cur, String target, String[] words, int cnt) {
        if(target.equals(cur)) {
            answer = cnt;
            return;
        }
        
        for(int idx = 0; idx < words.length; idx++) {
            
            if(visited[idx] == true) {
                continue;
            }
            
            int count = 0;
            
            for(int i = 0; i < cur.length(); i++) {
                if(cur.charAt(i) != words[idx].charAt(i)) count++;
            }
            
            if(count == 1) {
                visited[idx] = true;
                dfs(words[idx], target, words, cnt + 1);
                visited[idx] = false;
            }
            
        }
    }
}
