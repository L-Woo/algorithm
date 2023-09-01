// 최솟값이 8보다 크면 -1을 리턴
// 

import java.util.*; 

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] set = new HashSet[9];
        int num = 0;
        // 사용횟수로 모두 사용해서 만들 수 있는 수 ex) 55, 555
        for(int i = 1; i < 9; i++) {
            num = (num * 10) + N;
            set[i] = new HashSet<>();
            set[i].add(num);
        }
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : set[j]) {
                    for(Integer b : set[i - j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        // 0으로 나눌 수 없기 때문에 0이 아닌 수로 나눌 수 있도록 해야한다.
                        if(b != 0) {
                            set[i].add(a / b);
                        }  
                        if(a != 0) {
                            set[i].add(b / a);
                        }
                            
                    }
                }    
            }
            if(set[i].contains(number)){
                    return i;
            }
        }
        return answer;
    }
}
