class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int size = s.length();
        boolean flag = false;
        char std = 'A';
        int cntS = 0;
        int cntN = 0;
        for (int i = 0; i < size; i++) {
            char now = s.charAt(i);
            
            if (!flag) {
                std = now;
                cntS = 1;
                cntN = 0;
                flag = true;
            }else {
                if (now == std){
                    cntS++;
                }else {
                    cntN++;
                }
            }
            
            if (cntS == cntN) {
                answer++;
                flag = false;
            }
             
        }
        if (flag) answer++;
        
        return answer;
    }
}