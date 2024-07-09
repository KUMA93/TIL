class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        // 0 1
        // 1 11011  5^1
        // 2 11011 11011 00000 11011 11011   5^2
        // 3 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 ... 5^3
        
        // 0 1 '2' 3 4 10 11 '12' 13 14 '20' '21' '22' '23' '24' 30 31 '32' ...
        
        for (long i = l-1; i < r; i++) {
            if (getValue(i)) answer++;
        }
        
        return answer;
    }    
    
    public static boolean getValue(long idx) {
        
        while(idx >= 5){
            if (idx % 5 == 2) return false;
            idx /= 5;
        }
        
        if (idx == 2) return false;
        else return true;
    }
}