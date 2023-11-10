import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int truck : truck_weights) {
            while(true) {
                // q가 비어있다면 트럭을 추가
                if(q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                // 제일 먼저 들어온 트럭 다리 통과
                else if(q.size() == bridge_length) sum -= q.poll();
                else {
                    // 다리가 버틸 수 없는 무게인 경우
                    if(sum + truck > weight) {
                        q.add(0);
                        answer++;
                    }
                    // 다리가 버틸 수 있는 무게인 경우
                    else {
                        q.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }    
        }
        
        // answer는 현재 마지막 트럭이 다리에 들어온 시간이기 때문에 마지막 트럭의 통과 시간을 더 해야한다.
        return answer + bridge_length;
    }
}
