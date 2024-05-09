import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> solo = new ArrayDeque<>();
        
        for (int x : people) {
            dq.offer(x);
        }
        
        // System.out.println(dq);
        while (dq.size() > 1) {
            int light = dq.pollFirst();
            
            // 태울 수 없는 후보군 제외
            while (!dq.isEmpty() && light + dq.peekLast() > limit) {
                solo.offer(dq.pollLast());
            }
            
            // 동승자 태울 수 있는 경우 태우기
            if (!dq.isEmpty()) dq.pollLast();
            
            answer++;
        }
        
        answer += solo.size();
        answer += dq.size();
        
        return answer;
    }
}