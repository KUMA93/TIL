import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = want.length;
        
        Map<String, Integer> dc = new HashMap<>();
        
        int left = 0, right = 9;
        
        // dc 초기화
        for (int i = left; i <= right; i++) {
            dc.put(discount[i], dc.getOrDefault(discount[i], 0) + 1);
        }
        
        System.out.println(dc);
        
        while(right < discount.length) {
            boolean flag = true;
            
            for (int i = 0; i < size; i++) {
                String w = want[i];
                int num = number[i];
                
                if (dc.getOrDefault(w, 0) < num) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
            
            // dc 갱신
            dc.put(discount[left], dc.get(discount[left]) - 1);
            if (right < discount.length - 1) dc.put(discount[right+1], dc.getOrDefault(discount[right+1], 0) + 1);
            left++;
            right++;
            // System.out.println(dc);
        }
        
        return answer;
    }
}