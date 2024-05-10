class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int len = arrayA.length;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < len; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        if(checkDivide(arrayA, gcdB)) answer = Math.max(answer, gcdB);
        if(checkDivide(arrayB, gcdA)) answer = Math.max(answer, gcdA);
        
        return answer;
    }
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    } 
    
    static boolean checkDivide(int[] array, int gcd) {
        for(int num : array) {
            if(num % gcd == 0) return false;
        }
        return true;
    }
}
