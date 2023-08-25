// 일렬로 배치된 음식을 각 선수는 왼쪽 반대쪽 부터 시작해서 먹는다.
// 중앙에는 물을 배치하여 물은 가장 먼저 먹는 선수가 승리
// 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 한다.
// 음식의 순서도 같아야 하며, 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치해야 한다.
// 물은 0번이다.
// food[i]는 i번 음식의 수입니다.
// food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
// import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                sb.append(i);   
            }
        }
        answer += sb.toString();
        sb.append(0);
        answer += sb.reverse().toString();
        
        return answer;
    }
}
