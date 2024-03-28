import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Deque<Integer> res = new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        int size = progresses.length;
        for (int i = 0; i < size; i++) {
            int day = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            dq.offer(day);
        }
        
        System.out.println(dq);

        
        int std = dq.peekFirst();
        int num = 0;
        while(!dq.isEmpty()){
            int now = dq.pollFirst();
            if (std >= now) {
                num++;
            }else {
                res.offer(num);
                num = 0;
                dq.offerFirst(now);
                std = now;
            }
            
        }
        if (num != 0) res.offer(num);
        
        answer = res.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}