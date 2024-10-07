import java.util.*;

class Solution {
    static int n;
    static Set<Integer> res = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        n = elements.length;
                
        for (int i = 1; i <= n; i++) {
            makeSeq(elements, i);
        }
        
        answer = res.size();
        
        return answer;
    }
    
    void makeSeq(int[] arr, int k){
        int i = 0;
        
        while(i < n) {
            int sum = 0;
            int j = i + k;
            
            for (int c = i; c < j; c++) {
                int cur = c % n;
                sum += arr[cur];
            }
            res.add(sum);
            i++;
        }
        
    }
}