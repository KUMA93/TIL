import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> l = new HashSet<>();
        Set<Integer> r = new HashSet<>();
        
        for (int x : lost) {
            l.add(x);
        }
        
        for (int x : reserve) {
            r.add(x);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!l.contains(i)) answer++;
            else {
                if (r.contains(i)) {
                    r.remove(i);
                    answer++;
                }else if (r.contains(i-1)) {
                    r.remove(i-1);
                    answer++;
                }else if (r.contains(i+1) && !l.contains(i+1)) {
                    r.remove(i+1);
                    answer++;
                }
            }
        }
        return answer;
    }
}