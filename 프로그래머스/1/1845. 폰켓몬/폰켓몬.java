import java.util.*;

class Solution {
    // N/2
    
    public int solution(int[] nums) {
        int answer = 0;
        
        int size = nums.length;
        int pick = size / 2;
        
        Set<Integer> poke = new HashSet<>();
        
        for (int x : nums) {
            poke.add(x);
        }
        
        if (pick >= poke.size()) answer = poke.size();
        else answer = pick;
        
        return answer;
    }
}