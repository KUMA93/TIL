import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 0 2 11 14 17 21 25
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0, prev = 0;
            
            for (int x : rocks) {
                if (x - prev < mid) cnt++;
                else prev = x;
                
                if (cnt > n) break;
            }
            // System.out.println(left + " " + right);
            
            if (distance - prev < mid && cnt <= n) cnt++;
            
            if (cnt > n) right = mid - 1;
            else {
                
                left = mid + 1;
                answer = mid;
                
            }
        }
        
        return answer;
    }
}