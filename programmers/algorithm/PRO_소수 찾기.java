import java.util.*;

class Solution {
    
    static int answer = 0;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        
        for(int i = 1; i <= arr.length; i++) {
            perm(0, arr, new String[arr.length], new boolean[arr.length], i);    
        }
        
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            check(iter.next());
        }
        
        return answer;
    }
    
    static void perm(int depth, String[] arr, String[] out, boolean[] visited, int N) {
        if(depth == N) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                sb.append(out[i]);
            }
            
            int num = Integer.parseInt(sb.toString());
            set.add(num);
            
            return ;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                perm(depth + 1, arr, out, visited, N);
                visited[i] = false;
            }
        }
    }
    
    static void check(int num) {
        
        if(num < 2) return;
        for (int i = 2; i<=(int)Math.sqrt(num); i++){
			if(num % i == 0) return;
		}
		answer++;
		return;
        
    }
    
}
