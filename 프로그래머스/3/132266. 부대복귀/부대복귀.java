import java.util.*;

class Solution {
    static List<List<Integer>> map;
    static int[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        map = new ArrayList<>();
        visited = new int[n+1];
        
        Arrays.fill(visited, -1);
        
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int[] info : roads) {
            int a = info[0];
            int b = info[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        // for (List<Integer> x : map) {
        //     for (int y : x) {
        //         System.out.print(y + " ");
        //     }
        //     System.out.println();
        // }
        
        bfs(destination);
        
        // System.out.println(Arrays.toString(visited));
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visited[sources[i]];
        }
        return answer;
    }
    
    
    void bfs(int start) {
        Deque<int[]> dq = new ArrayDeque<>();
        visited[start] = 0;
        dq.offer(new int[]{start, 0});
        
        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            List<Integer> nexts = map.get(cur[0]);
            
            // System.out.println("다음 목적지: " + nexts);
            for (int next : nexts) {
                // 방문한 곳이면 스킵
                if (visited[next] != -1) continue;
                
                visited[next] = cur[1] + 1;
                dq.offer(new int[]{next, cur[1]+1});
            }
        }
    }
}