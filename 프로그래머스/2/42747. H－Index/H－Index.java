import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        
        Integer[] tmp = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            tmp[i] = citations[i];
        }
        
        Arrays.sort(tmp, Collections.reverseOrder());
        
        int std = tmp[0];
        
        for (int i = std; i >= 0; i--) {
            
            int num = 0;
            System.out.println("검사 " + i);
            
            for (int j = 0; j < n; j++){
                if (tmp[j] >= i) num++;
            }
            
            if (num >= i) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}