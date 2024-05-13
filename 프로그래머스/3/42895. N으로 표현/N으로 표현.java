import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        // N / N = 1 -> 2
        // 1 * N = N -> 3
        // 

        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        dp.add(new HashSet<>());
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            dp.add(new HashSet<>());
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            dp.get(i).add(makeSerialNum(N, i));
        }
        
        for (int i = 1; i < 9; i++) {
            if (dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public static int makeSerialNum(int N, int k) {
        StringBuilder num = new StringBuilder();
        
        for (int i = 0; i < k; i++) num.append(N);
        
        return Integer.parseInt(num.toString());
    }
}