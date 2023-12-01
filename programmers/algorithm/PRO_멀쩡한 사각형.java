class Solution {
    public long solution(int w, int h) {
		long answer = 1;
        
		long r = (long)h; 
        long c = (long)w; 
		
		answer = (c * r) - ((c + r) - gcd(c, r));
		
		return answer;
	}

	private static long gcd(long w, long h) {
		if(h == 0) {
			return w;
		}
		return gcd(h, w % h);
	}
}
