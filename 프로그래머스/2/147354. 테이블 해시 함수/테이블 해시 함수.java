import java.util.*;

class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            else return o1[col-1] - o2[col-1];
        });
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {

            int sum = 0;
            
            for (int x : data[i]) {
                sum += x % (i + 1);
            }
            
            answer ^= sum;
        }
        
        // System.out.println(res);
        
        return answer;
    }
}