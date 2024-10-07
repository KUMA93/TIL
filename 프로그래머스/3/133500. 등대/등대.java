import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> tree;
    static boolean[] lighted, visited;
    static int answer;
    
    public int solution(int n, int[][] lighthouse) {
        answer = 0;
        lighted = new boolean[n+1];
        visited = new boolean[n+1];
        tree = new HashMap<>();
        // 트리로 변형
        for (int[] x : lighthouse) {
            int a = x[0];
            int b = x[1];
            
            tree.putIfAbsent(a, new ArrayList<>());
            tree.putIfAbsent(b, new ArrayList<>());
        
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        // for (List<Integer> x: tree.values()){
        //     System.out.println(x);
        // }
        visited[1] = true;
        dfs(1, 0);
        
        return answer;
    }
    
    void dfs(int cur, int parent) {
            
        List<Integer> adj = tree.get(cur);
        boolean flag = true;

        for (int a : adj) {
            if (visited[a]) continue;
            visited[a] = true;
            dfs(a, cur);
        }
        
        for (int a : adj) {
            if (!lighted[a]) flag = false;
        }
        
        // 자식노드의 불이 다 켜져있거나 자신의 불이 켜져있다면 불을 키지 않는다.
        if (flag || lighted[cur]) return;
        
        if (!lighted[parent]){
            lighted[parent] = true;
            // System.out.println(parent);
            answer++;
        }
    }
}