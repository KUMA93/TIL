import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int[] cnt = new int[e+1];
        int[] res = new int[e+1];
        
        for (int i = 2; i < e+1; i++) {
            int next = Math.min(e/i+1, i);
            for (int j = 1; j < next; j++) {
                cnt[i*j] += 2;
            }
        }
        
        int next = (int)Math.sqrt(e) + 1;
        for (int i = 1; i < next; i++) {
            cnt[(int)Math.pow(i, 2)] += 1;
        }
        
        int max = 0;
        int maxIdx = e;
        
        for (int start = e; start >= 1; start--) {
            if (max <= cnt[start]) {
                max = cnt[start];
                maxIdx = start;
            }
            
            res[start] = maxIdx;
        }
        
        for (int i = 0; i < starts.length; i++) {
            answer[i] = res[starts[i]];
        }
        // System.out.println(Arrays.toString(res));
        
        return answer;
    }
}