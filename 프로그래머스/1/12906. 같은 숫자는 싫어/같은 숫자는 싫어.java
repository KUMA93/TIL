import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> res = new ArrayList<>();
        
        int std = -1;
        for (int x : arr) {
            if (x == std) continue;
            res.add(x);
            std = x;
        }
        
        answer = res.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}