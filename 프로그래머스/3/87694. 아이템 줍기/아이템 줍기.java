import java.util.*;

class Solution {
    
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int dt = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map = new int[101][101];
        
        // 영역 마킹
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            fill(x1, x2, y1, y2);
        }
        
        // for (int[] x : map){
        //     for (int y : x) {
        //         System.out.printf("%d ", y);
        //     }
        //     System.out.println();
        // }
        
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        answer = dt;
        return answer;
    }
    
    public static void fill(int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;
                if (i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                else map[i][j] = 2;
            }
        }
    }
    
    public static boolean isInMap(int x, int y) {
        return (0 <= x && x < 101) && (0 <= y && y < 101);
    }
    
    public static void bfs(int sx, int sy, int tx, int ty) {
        Deque<Integer[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        
        dq.offer(new Integer[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!dq.isEmpty()) {
            Integer[] now = dq.pollFirst();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            // System.out.printf("현재 좌표: %d, %d  거리: %d\n", x, y, cnt);
            
            if (x == tx && y == ty) {
                dt = cnt / 2;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!isInMap(nx, ny) || map[nx][ny] != 1 || visited[nx][ny]) continue;
                
                dq.offer(new Integer[]{nx, ny, cnt + 1});
                visited[nx][ny] = true;
            }
        }
    }
    
}