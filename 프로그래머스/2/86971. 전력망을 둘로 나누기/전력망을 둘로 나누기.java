import java.util.*;

class Solution {
    
    static int[] parents;
    static int size;
    
    public void make() {
        parents = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            parents[i] = i;
        }
    }
    
    public int find(int u) {
        if (parents[u] == u) return u;
        else return parents[u] = find(parents[u]);
    }
    
    public void union(int u, int v) {
        parents[find(u)] = find(v);
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int len = wires.length;
        
        size = n;
        
        // 전선 하나 끊기
        for (int i = 0; i < len; i++) {
            make();
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < len; j++) {
                if(i == j) continue;
            
                // union
                union(wires[j][0], wires[j][1]);
            }
            
            // root 찾기
            for (int j = 1; j <= size; j++) {
                int parent = find(j);
                map.put(parent, map.getOrDefault(parent, 0) + 1);
            }
            
            // System.out.println(Arrays.toString(parents));
            // System.out.println(map.values());
            
            List<Integer> vals = new ArrayList(map.values());
            
            answer = Math.min(answer, Math.abs(vals.get(0) - vals.get(1)));
        }
        
        
        return answer;
    }
    
}