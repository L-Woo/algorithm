// 보조 컨테이너 벨트는 가장 마지막에 보관한 상자부터 꺼낼 수 있다. -> 스텍구조

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int curBox = 1;
        int idx = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        while(true) {
            // 보조 컨테이버 벨트에 값이 있고 마지막으로 넣은 값이 원하는 값과 같을 때
            if(!stack.isEmpty() && order[idx] == stack.peek()) {
                answer++;
                idx++;
                stack.pop();
                continue;
            }
            // 기존 컨테이버 벨트를 모두 돌았다면 종료
           if(curBox > order.length) {
                break;
            }
            
            // 기존 컨테이너 벨트의 값이 원하는 값고 같을 때
            if(order[idx] == curBox) {
                answer++;
                curBox++;
                idx++;
                continue;
            }
            // 모든 조건에 해당하지 않는다면 기존 컨테이너 벨트의 박스를 
            // 보조 컨테이너 벨트로 이동 
            stack.push(curBox);
            curBox++;
            
        }
        
        return answer;
    }
}
