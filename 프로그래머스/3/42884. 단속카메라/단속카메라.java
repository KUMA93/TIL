import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        
        int installed = -30001;
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (start <= installed) {
                if (end < installed) installed = end;
                continue;
            }else {
                answer++;
                installed = end;
            }
        }
        
        return answer;
    }
}