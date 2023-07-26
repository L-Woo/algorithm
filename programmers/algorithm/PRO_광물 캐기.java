// 다이아, 철, 돌 곡괭이는 각각 0 ~ 5개를 가지고 있다.
// 곡괭이는 광물에 상관없이 5개를 캔 후에는 더 이상 사용할 수 없다.
// 한 번 사용한 곡괭이는 사용할 수 없을 때까지 사용한다.
// 광물은 주어진 순서대로만 캘 수 있다.
// 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캔다.

class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        int cnt = 0;
        for(int pick : picks) {
            cnt += pick;
        }
        
        dfs(picks, minerals, new int[cnt], 0);
        
        return answer;
    }
    
    static void dfs(int[] picks, String[] minerals, int[] orders, int idx) {
        
        if(idx == orders.length) {
            getFatigue(orders, minerals);
            return;
        }
        // 0 = 다이아, 1 = 철, 2 = 돌
        // orders배열에 선택한 곡괭이를 넣는다.
        for(int i = 0; i < 3; i++) {
            if(picks[i] > 0) {
                orders[idx] = i;
                picks[i]--;
                dfs(picks, minerals, orders, idx + 1);
                picks[i]++;
            }
        }
        
    }    
    
    static void getFatigue(int[] orders, String[] minerals) {
        
        int idx = 0;
        int cost = 0;
        
        for(int order : orders) {
            // 곡괭이를 한 번 사용하면 반드시 5개를 캔 후에 교체할 수 있다.
            for(int i = 0; i < 5; i++) {
                // 다이아 곡괭이는 어떤 광석을 만나도 1의 피로도를 소모
                if(order == 0) {
                    cost += 1;
                }
                // 철 곡괭이는 다이아몬드를 만나면 5의 피로도를 소모하고 나머지 광석은 1을 소모
                else if(order == 1) {
                    if(minerals[idx].equals("diamond")) {
                        cost += 5;
                    }else {
                        cost += 1;
                    }
                }
                // 돌 곡괭이는 다이아몬드 25, 철 5, 돌 1의 피로도를 소모
                else {
                    if(minerals[idx].equals("diamond")) {
                        cost += 25;
                    }else if(minerals[idx].equals("iron")) {
                        cost += 5;
                    }else {
                        cost += 1;
                    }
                }
                if(++idx >= minerals.length) {
                    break;
                }
            }
            if(idx >= minerals.length) {
                break;
            }
        }
        answer = Math.min(answer, cost);
    }
    
}
