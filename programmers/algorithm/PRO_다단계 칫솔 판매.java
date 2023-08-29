// 민호는 center
// 모든 판매원은 칫솔의 판매에 의하여 발생하는 이익에서 10%를 계산하여 
// 자신을 조직에 참여시킨 추천인에게 배분하고 나머지를 가진다.
// 자신이 조직에 추천하여 가입시킨 판매원에게 발생하는 이익의 10%도 챙긴다.
// 단, 10% 를 계산할 때에는 원 단위에서 절사하며, 
// 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.
// enroll은 민호를 제외한 조직 구성원의 총 수
// referral의 길이는 enroll의 길이와 같으며 i번째에 있는 이름은 배열 enroll에서 i번째에 있는 판매원을 조직에 참여시킨 사람의 이름이다.
// 만약 추천으로 들어온 사람이 아니라면 "-"가 기입된다.
// seller 내의 i 번째에 있는 이름은 i 번째 판매 집계 데이터가 어느 판매원에 의한 것인지를 나타냅니다.
// 칫솔 1개는 100원

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> parentMap = new HashMap<>(); // <자신, 부모>
        Map<String, Integer> memberIndexMap = new HashMap<>(); // <자신, 자신의 순서>

        for(int i=0; i < enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            
            String cur = seller[i];
            int profit = 100 * amount[i]; // 칫솔은 개당 100원
            
            while(!cur.equals("-")) {
                
                int parentProfit = profit / 10;
                int curProfit = profit - parentProfit;
                
                answer[memberIndexMap.get(cur)] += curProfit;
                
                cur = parentMap.get(cur);
                profit = parentProfit;
                
                if(profit < 1) {
                    break;
                }
                
            }
            
        }
        
        return answer;
    }
}
