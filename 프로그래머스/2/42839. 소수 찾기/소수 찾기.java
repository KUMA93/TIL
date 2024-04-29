import java.util.*;

class Solution {
    
    static Set<Integer> prime;
    
    public int solution(String numbers) {
        int answer = 0;
        int size = numbers.length();
        char[] cand = new char[size];
        prime = new HashSet<>();
        
        for (int i = 0; i < size; i++) {
            cand[i] = numbers.charAt(i);
        }
        
        
        int[] num = new int[size];
        boolean[] visited = new boolean[size];
        
        dfs(0, size, num, cand, visited);
        
        answer = prime.size();
        return answer;
    }
    
    public static void dfs(int idx, int depth, int[] num, char[] cand, boolean[] visited) {
        if(idx == depth) return;
        
        for (int i = 0; i < cand.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            num[idx] = i;
            String tmp = "";
            for (int j = 0; j <= idx; j++) {
                tmp += cand[num[j]];
            }
            int res = Integer.parseInt(tmp);
            // System.out.println(res);
            if (isPrimeNumber(res)) prime.add(res);
            dfs(idx+1, depth, num, cand, visited);
            visited[i] = false;
        }
    }
    
    public static boolean isPrimeNumber(int x) {
        if (x == 0 || x == 1) return false;
        
        for (int i = 2; i <= Math.floor(Math.sqrt(x)); i++) {
            if (x % i == 0) return false;
        }
        
        return true;
    }
    
}