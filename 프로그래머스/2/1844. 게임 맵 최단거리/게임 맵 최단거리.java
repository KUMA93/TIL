import java.util.*;

class Solution {
    
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m, cnt;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        cnt = -1;
        
        map = maps;
        
        bfs(0, 0);
            
        answer = cnt;
        return answer;
    }
    
    public static void bfs(int sx, int sy) {
        Deque<Integer[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        dq.offer(new Integer[]{sx, sy, 1});
        visited[sx][sy] = true;
        
        while(!dq.isEmpty()) {
            Integer[] now = dq.pollFirst();
            int x = now[0];
            int y = now[1];
            int dt = now[2];
            
            if (x == n-1 && y == m-1){
                cnt = dt;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isInMap(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

                dq.offer(new Integer[]{nx, ny, dt+1});
                visited[nx][ny] = true;
            }    
        }
        
    }
    
    public static boolean isInMap(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }
}