import java.util.*;

class Solution {
    static int answer;
    static boolean[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void searchPath(int sx, int sy, String[] maps){
        Deque<int[]> dq = new ArrayDeque<>();
        visited = new boolean[maps.length][maps[0].length()][2];

        dq.offer(new int[] {sx, sy, 0, 0});

        while(!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int x = now[0];
            int y = now[1];
            int dt = now[2];
            int state = now[3];

            if (maps[now[0]].charAt(now[1]) == 'E' && state == 1) {
                answer = dt;
                break;
            }
            
            if (maps[now[0]].charAt(now[1]) == 'L' && state == 0) state = 1;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(0 <= nx && nx < maps.length) || !(0 <= ny && ny < maps[0].length()) || visited[nx][ny][state] || maps[nx].charAt(ny) == 'X') continue;
                visited[nx][ny][state] = true;
                dq.offer(new int[] {nx, ny, dt+1, state});
            }
        }


    }

    public int solution(String[] maps) {
        answer = -1;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char now = maps[i].charAt(j);
                if (now == 'S'){
                    searchPath(i, j, maps);
                    break;
                }
            }
        }


        return answer;
    }
}