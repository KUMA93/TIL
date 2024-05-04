import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0, sum = 0;
        int size = jobs.length;
        
        // 수행할 작업 큐
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 요청이 들어온 순서의 작업 큐
        Queue<int[]> in = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for (int[] x : jobs) {
            in.add(x);
        }
        
        while(!pq.isEmpty() || !in.isEmpty()) {
            // 수행할 수 있는 작업 전부 옮김
            while (!in.isEmpty()){
                if (in.peek()[0] <= time) pq.add(in.poll());    
                else break;
            }
            
            // 하드 디스크가 아무 작업도 하고 있지 않을 경우
            if (pq.isEmpty() && !in.isEmpty()) {
                time = in.peek()[0];
                while(!in.isEmpty()) {
                    if (in.peek()[0] == time) pq.add(in.poll());
                    else break;
                }
            }
            
            // 작업 수행 및 소요 시간 계산
            int[] process = pq.poll();
            time += process[1];
            sum += time - process[0];
            
        }
        
        answer = (int)Math.floor(sum / size);
        
        return answer;
    }
}