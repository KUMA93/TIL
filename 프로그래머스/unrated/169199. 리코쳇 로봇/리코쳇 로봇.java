import java.util.*;

class Solution {
    //"R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점
    
    static int xSize, ySize;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static class pos {
        int x;
        int y;
        int cnt;
        
        public pos (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    
    public int solution(String[] board) {
        int answer = 0;
        
        xSize = board.length;
        ySize = board[0].length();
        
        map = new char[xSize][ySize];
        visited = new boolean[xSize][ySize][4];
        
        int startX = 0;
        int startY = 0;
        
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                char now = board[i].charAt(j);
                
                map[i][j] = board[i].charAt(j);
                
                if (now == 'R') {
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                }
            }
        }
        
        Deque<pos> dq = new ArrayDeque<>();
        dq.offer(new pos(startX, startY, 0));
        
        while(!dq.isEmpty()) {
            pos now = dq.pollFirst();
            int x = now.x;
            int y = now.y;
            
            if (map[x][y] == 'G') {
                answer = now.cnt;
                return answer;
            }
            
            for (int i = 0; i < 4; i++) {
                int cnt = now.cnt;
                if (visited[x][y][i]) continue;
                int nx = x;
                int ny = y;
                
                visited[x][y][i] = true;
                cnt++;
                
                int move = 0;
                while((0 <= nx && nx < xSize) && (0 <= ny && ny < ySize) && map[nx][ny] != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                    move++;
                }
                move--;
                
                nx = x + dx[i]*move;
                ny = y + dy[i]*move;
                
                dq.offer(new pos(nx, ny, cnt));
            }
        }
        
        return -1;
    }
}