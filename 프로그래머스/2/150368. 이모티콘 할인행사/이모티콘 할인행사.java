import java.util.*;

class Solution {
    static int size;
    static int[] emos, dcVals;
    static int[][] user;
    static Queue<Result> pq = new PriorityQueue<>();
    
    class Result implements Comparable<Result>{
        int newReg;
        int sales;
        
        Result(int newReg, int sales) {
            this.newReg = newReg;
            this.sales = sales;
        }
        
        @Override
        public int compareTo(Result o) {
            if (this.newReg == o.newReg) return o.sales - this.sales;
            return o.newReg - this.newReg;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        size = emoticons.length;
        emos = emoticons;
        user = users;
        dcVals = new int[size];

        permutation(0);
        // 할인율은 10, 20, 30, 40 중 하나
        // 4^7 8000*100*7
        

        Result res = pq.poll();
        answer[0] = res.newReg;
        answer[1] = res.sales;
        
        return answer;
    }
    
    void permutation(int cnt) {
        if (cnt == size) {
            int sales = 0;
            int newReg = 0;

            for (int i = 0; i < user.length; i++) {
                int std = user[i][0];
                int limit = user[i][1];
                int sum = 0;

                for (int j = 0; j < size; j++) {    
                    if (std <= dcVals[j]) sum += emos[j] / 100 * (100 - dcVals[j]);
                    if (sum >= limit) {
                        sum = 0;
                        newReg++;
                        break;
                    }
                }

                sales += sum;
            }
            
            pq.offer(new Result(newReg, sales));
            
            return;
        }
        
        for (int i = 10; i <= 40; i+=10){
            dcVals[cnt] = i;                
            permutation(cnt+1);
        }
    }
}