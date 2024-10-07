import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int x : scoville) {
            pq.add(x);
        }
        
        int cnt = 0;
        while(pq.peek() < K) {
            if (pq.size() < 2) break;
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second*2;

            pq.add(mix);
            cnt++;
        }

        if (pq.peek() < K) return -1;
        else return cnt;
    }

}