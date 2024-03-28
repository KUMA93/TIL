import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int size = s.length();
        Deque<Character> dq = new ArrayDeque<>();
        
        for (int i = 0; i < size; i++) {
            char now = s.charAt(i);
            
            if (now == '(') dq.offer(now);
            else {
                if (dq.isEmpty()) {
                    answer = false;
                    break;
                }else {
                    if (dq.pollLast() == ')') {
                        answer = false;
                        break;
                    }
                }
            }
        }
        
        if (!dq.isEmpty()) answer = false;
        
        while(!dq.isEmpty()){
            char now = dq.pollLast();
            
        }

        return answer;
    }
}