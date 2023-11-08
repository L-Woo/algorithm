// 각 종류별로 최대 1가지 의상만 착용할 수 있다.
// 코니는 하루에 최소 한 개의 의상은 입습니다.

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        // HashMap에 의상 종류와 갯수를 저장
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        // 해당 종류의 갯수에 이 의상 종류를 안 입는 경우를 생각해서 1을 더 한 값을 answer에 곱한다.
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }
        // 전부 다 안 입지 않은 경우는 뺀다.
        return answer - 1;
    }
}
