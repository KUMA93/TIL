import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        int size = s.length();
        
        // 회전
        for (int i = 0; i < size; i++) {
            s = s.substring(1, size) + s.charAt(0);

            // 유효성 검사
            Deque<Character> dq = new ArrayDeque();
            boolean flag = true;
            
            for (int j = 0; j < size; j++) {
                char now = s.charAt(j);
                
                if (now == '(' || now == '[' || now == '{') dq.offer(now);
                else if (now == ')' && (dq.isEmpty() || dq.pollLast() != '(')) flag = false;
                else if (now == ']' && (dq.isEmpty() || dq.pollLast() != '[')) flag = false;
                else if (now == '}' && (dq.isEmpty() || dq.pollLast() != '{')) flag = false;
            }
            
            if (!dq.isEmpty()) flag = false;
            
            if (flag) answer++;
            
        }

        return answer;
    }
}