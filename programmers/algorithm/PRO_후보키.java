import java.util.*;

class Solution {
    
    static int R, C;
    static List<String> keyList = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        R = relation.length;
        C = relation[0].length;
        
        for(int i = 1; i <= R; i++) {
            boolean[] selected = new boolean[C];
            dfs(0, 0, i, selected, relation);
        }
        answer = keyList.size();
        return answer;
    }

    static void dfs(int idx, int cnt, int target, boolean[] selected, String[][] relation) {
        if(cnt == target) {
            List<Integer> list = new ArrayList<>();
            String key = "";
            
            for(int i = 0; i < C; i++) {
                if(selected[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            
            HashSet<String> set = new HashSet<>();
            // 유일성 검사
            for(int i = 0; i < R; i++) {
                String str = "";
                // 선택된 열 조합으로 문자열을 생성
                for (Integer j : list) {
                    str += relation[i][j];
                }
                // 이미 있는 조합이라면 후보키가 될 수 없으므로 반환
                if (!set.add(str)) {
                    return;
                }
            }
            // 최소성 검사
            for(String str : keyList) {
                int count = 0;
                for(int i = 0; i < key.length(); i++) {
                    String subs = String.valueOf(key.charAt(i));
                    if(str.contains(subs)) count++;
                }
                // 현재 조합이 이미 후보키에 포함되어 있다면 반환
                if(count == str.length()) return;
            }
            // 후보키 리스트에 추가
            keyList.add(key);
            return;
            
        }
        
        for(int i = 0; i < C; i++) {
            if(selected[i]) continue;
            selected[i] = true; 
            dfs(idx + 1, cnt + 1, target, selected, relation); 
            selected[i] = false;
        }    
    }
    
}
