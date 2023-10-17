class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        if(arr.length == 1) return arr[0];
        
        int temp = gcd(arr[0], arr[1]); 
        answer = (arr[0] * arr[1]) / temp;
        
        if(arr.length > 2) { 
            for(int i = 2; i < arr.length; i++) {
                temp = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / temp;
            }
        }
  
        return answer;
    }
    
    int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}
