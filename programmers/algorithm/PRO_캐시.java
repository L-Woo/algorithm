import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new ArrayList<>();
        
        for(String str : cities) {
            // 대소문자 구분을 하지 않기 때문에 전체를 소문자로 변경
            str = str.toLowerCase();
            // 캐시에 저장이 되어있는 경우
            // LRU 알고리즘이기 때문에 list에서 기존의 정보를 제거 후 새로 추가
            if(list.contains(str)) {
                answer += 1;
                list.remove(str);
                list.add(str);
            }
            // 캐시에 저장되어 있지 않은 경우
            else {
                list.add(str);
                answer += 5;
                
            }
            // cacheSize를 넘어서면 list에서 가장 먼저 들어온 캐시 제거
            while(list.size() > cacheSize) {
                list.remove(0);
            }
        }
        
        return answer;
    }
}
