import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int size = prices.length;
        int[] answer = new int[size];
        List<Integer> list = new ArrayList<>();
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int x : prices) dq.offer(x);
        
        while(!dq.isEmpty()) {
            int cur = dq.pollFirst();
            int time = 0;
            int len = dq.size();
            
            for (int x : dq) {
                time++;
                if (cur > x) break; 
            }
            
            list.add(time);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}