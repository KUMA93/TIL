class Solution {
    
    static int[][] map;
    static boolean[] visited;
    static int cnt;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        map = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n);
                cnt++;
            }
        }
        
        answer = cnt;
        return answer;
    }
    
    public static void dfs(int node, int n) {
        
        for (int i = 0; i < n; i++) {
            if (map[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}