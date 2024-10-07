import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> tmp = new ArrayDeque<>();
        int cur = 1;
        
        for (int o : order) {
            
            while(cur < o) {
                tmp.offer(cur);
                cur++;
            }
            
            if (cur == o) {
                cur++;
                answer++;
            }
            else if (!tmp.isEmpty() && tmp.peekLast() == o){
                tmp.pollLast();
                answer++;
            }else break;            
        }
        
        return answer;
    }
}