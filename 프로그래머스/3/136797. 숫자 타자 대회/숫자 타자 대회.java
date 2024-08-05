import java.util.*;

class Solution {
    
    static final int costs[][] = {{ 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
                                   { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
                                   { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
                                   { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
                                   { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
                                   { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
                                   { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
                                   { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
                                   { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
                                   { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }};
    static int[][][] dp;
    static String num;
    static int len;
        
    public int solution(String numbers) {
        num = numbers;
        len = numbers.length();
    
        // dp 초기화
        dp = new int[len+1][10][10];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);
        }
    
        return solve(0, 4, 6);
    }
    
    int solve(int idx, int left, int right) {
        
        if (idx == len) return 0;
        
        if (dp[idx][left][right] != -1) return dp[idx][left][right];
        
        int now = num.charAt(idx) - '0';
        int res = Integer.MAX_VALUE;
        
        if (now != right) res = Math.min(solve(idx+1, now, right) + costs[left][now], res);
        
        if (now != left) res = Math.min(solve(idx+1, left, now) + costs[right][now], res);
        
        return dp[idx][left][right] = res;
        
    }
}