import java.util.*;

class Solution {
    // 다익스트라.... 근데 코드 어캐 짜는지 모름...
    // bfs 되나..?
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] rel = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++) {
            rel[i] = new ArrayList<>();
        }
        
        // 인접 리스트로 재구성
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            rel[a].add(b);
            rel[b].add(a);
        }
        
        int[] res = new int[n+1];
        

        Deque<int[]> dq = new ArrayDeque<>();
        int[] visited = new int[n+1];
        dq.offer(new int[] {1, 0});
        int max = 0;
        
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            
            for (int x : rel[now[0]]){
                if (visited[x] != 0) continue;
                visited[x] = now[1] + 1;
                dq.offer(new int[] {x, now[1] + 1});
            }
        }
        
        System.out.println(Arrays.toString(visited));
        
        
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, visited[i]);
        }
        
        
        
        for (int i = 2; i <= n; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}