import java.util.*;

class Solution {
    
    class Tuple implements Comparable<Tuple> {
        
        int[] arr;
        int col;
        
        Tuple(int[] arr, int col) {
            this.arr = arr;
            this.col = col;
        }
        
        @Override
        public int compareTo(Tuple o) {
            if (this.arr[col-1] == o.arr[col-1]) return o.arr[0] - this.arr[0];
            else return this.arr[col-1] - o.arr[col-1];
        }
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // Arrays.sort(data, (o1, o2) -> {
        //     if (o1[col-1] == o2[col-1]) return o2[0] - o1[0];
        //     else return o1[col-1] - o2[col-1];
        // });
        
        Queue<Tuple> pq = new PriorityQueue<>();
        for (int[] x : data) {
            pq.offer(new Tuple(x, col));
        }
        
        int cur = 1;
        
        while(cur <= row_end) {
            Tuple t = pq.poll();
            
            if (cur < row_begin) {
                cur++;
                continue;
            }
            
            int sum = 0;
            for (int x : t.arr) {
                sum += x % cur;
            }
            
            answer ^= sum;
            cur++;
        }
        
//         for (int i = row_begin - 1; i <= row_end - 1; i++) {

//             int sum = 0;
            
//             for (int x : data[i]) {
//                 sum += x % (i + 1);
//             }
            
//             answer ^= sum;
//         }
        
        return answer;
    }
}