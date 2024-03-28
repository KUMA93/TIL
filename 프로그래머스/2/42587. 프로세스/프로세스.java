import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : priorities) {
            pq.add(x);
        }
        
        while(!pq.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    
                    if (location == i) return answer;             
                }
            }
        }
        
        return answer;
    }
}