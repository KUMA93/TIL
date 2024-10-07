import java.util.*;

class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Arrays.fill(answer, -1);

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = numbers.length - 1; i >= 0; i--) {
                
                while(!dq.isEmpty() && dq.peekLast() <= numbers[i]){
                    dq.pollLast();
                }
                if (!dq.isEmpty() && dq.peekLast() > numbers[i]) answer[i] = dq.peekLast();           
                dq.offer(numbers[i]);
            }
        

            return answer;
        }
    }