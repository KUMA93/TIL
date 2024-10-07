import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<Integer[]> dq = new ArrayDeque<>();
        int size = truck_weights.length;
        int capa = weight;
        
        for (int x : truck_weights) {
            int len = dq.size();
            
            // 수용 가능하면
            if (capa >= x) {
                capa -= x;
                if (!dq.isEmpty()) dq.offer(new Integer[]{x, dq.peekLast()[1] + 1});
                else dq.offer(new Integer[]{x, bridge_length});
            }else {
                int time = 0;
                
                while (capa < x) {
                    Integer[] first = dq.pollFirst();
                    capa += first[0];
                    // System.out.printf("%d를 스택에 추가하기 위해 %d 트럭 완료, capa: %d\n", x, first[0], capa);
                    time = first[1] + bridge_length;
                }
                capa -= x;
                
                if (!dq.isEmpty()) time = Math.max(time, dq.peekLast()[1] + 1);
                dq.offer(new Integer[]{x, time});
            }

        }
        
        // for (Integer[] x : dq) {
        //     System.out.printf("{%d %d} ", x[0], x[1]);
        // }
        
        answer = dq.peekLast()[1] + 1;
        
        return answer;
    }
}