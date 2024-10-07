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
                if (dq.isEmpty() ) {
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
//         int count = 0;
        
//         for (char c : s.toCharArray()) {
//             if (c == '(') count++;
//             else {
//                 if (count == 0) return false; // 닫는 괄호가 먼저 나오면 false 반환
//                 count--;
//             }
//         }
        
//         return count == 0; // 모든 괄호가 쌍을 이루었는지 확인
    }
}