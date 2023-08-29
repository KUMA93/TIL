class Solution {
    
    public static long solution(int r1, int r2) {
        
        long answer = 0;

        // r1 <= root(x^2 + y^2) <= r2
        // r1^2 <= x^2 + y^2 <= r2^2
        // y^2 <= r2^2 - x^2
        // y <= root(r2^2 - x^2)
        // root(r1^2 - x^2) <= y

        long r1p = (long)Math.pow(r1, 2);
        long r2p = (long)Math.pow(r2, 2);
        
        long y1 = 0;
        long y2 = 0;
        long extra = 0;
        for (int i = 0; i < r2; i++) {
            
            if(Math.sqrt(r1p - (long)Math.pow(i, 2)) % 1 == 0.0) extra++;
            
            y1 = (long)Math.sqrt(r1p - (long)Math.pow(i, 2));
            y2 = (long)Math.sqrt(r2p - (long)Math.pow(i, 2));
            // System.out.printf("%d, %d\n",y1, y2);
            answer += (y2 - y1) * 4;
        }
        answer += extra * 4 - 4;
        return answer;
        
    }
}