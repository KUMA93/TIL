import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 사람 n명, 심사 시간 times, 모든 사람 심사 시간
        long left = 0;
        long right = Long.MAX_VALUE / 100;
        long mid = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            long cnt = 0;
            
            for (int time : times) {
                cnt += mid / time;
            }
            
            if (n <= cnt) right = mid;
            else left = mid + 1;
        }
        
        answer = left;
        
        return answer;
    }
}