import java.util.*;

class Solution {
    
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ter = 2, n, m, quantity;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        map = land;
        Map<Integer, Integer> oil = new HashMap<>();
        n = map.length;
        m = map[0].length;
        
        
        // 구역별 마킹 및 덩어리 크기 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    quantity = 0;
                    dfs(i, j);
                    oil.put(ter, quantity);
                    ter++;
                }
            }
        }
            
        // 시추 구멍 뚫기
        Set<Integer> select;
        
        for (int i = 0; i < m; i++) {
            
            select = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (map[j][i] != 0) {
                    select.add(map[j][i]);
                }
            }
            
            int sum = 0;
            for (int x : select) {
                sum += oil.get(x);
            }

            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    void dfs(int sx, int sy) {

        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sx, sy});
        map[sx][sy] = ter;
        quantity++;
        
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!isInMap(nx, ny) || map[nx][ny] != 1) continue;

                dq.offer(new int[]{nx, ny});
                map[nx][ny] = ter;
                quantity++;
            }
        }
    }
    
    boolean isInMap(int x, int y) {
        return ((0 <= x && x < n) && (0 <= y && y < m));
    }
}