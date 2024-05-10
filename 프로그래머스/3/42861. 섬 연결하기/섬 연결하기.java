import java.util.*;

class Solution {
    static int[] parents;
    
    public static int find(int u) {
        if (parents[u] == u) return u;
        else return parents[u] = find(parents[u]);
    }
    
    public static void union(int u, int v) {
        parents[find(v)] = find(u);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        
        for (int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int[] info : costs) {
            if (find(info[0]) != find(info[1])) {
                union(info[0], info[1]);
                answer += info[2];
            }
            
        }
        
        return answer;
    }
}