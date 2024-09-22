import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int size = diffs.length;
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();

        int mid = 0;
        
        // 완탐은 100000 * 300000 이라서 안댐,, 이분탐색
        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < size; i++) {
                int diff = diffs[i];
                int curTime = times[i];
                int prevTime = 0;
                
                if (i > 0) prevTime = times[i-1];

                if (diff <= mid) sum += curTime;
                else sum += (prevTime + curTime) * (diff - mid) + curTime;
            }
            
            if (sum > limit) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}