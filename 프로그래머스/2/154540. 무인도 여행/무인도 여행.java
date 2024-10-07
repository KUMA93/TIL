import java.util.*;

class Solution {

        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, -1, 0, 1};
        boolean[][] visited;

        public int sumIsland(String[] map, int sx, int sy) {
            int sum = 0;
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] {sx, sy});
            sum += map[sx].charAt(sy) - '0';
            visited[sx][sy] = true;

            while(!dq.isEmpty()) {
                int[] now = dq.pollFirst();
                int x = now[0];
                int y = now[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!(0 <= nx && nx < map.length) || !(0 <= ny && ny < map[0].length()) || visited[nx][ny] || map[nx].charAt(ny) == 'X') continue;

                    sum += map[nx].charAt(ny) - '0';
                    dq.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }

            return sum;
        }


        public int[] solution(String[] maps) {
            int[] answer = {};

            List<Integer> tmp = new ArrayList<>();
            visited = new boolean[maps.length][maps[0].length()];


            for (int i = 0; i < maps.length; i++) {
                for (int j = 0;  j < maps[0].length(); j++) {
                    if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                        visited[i][j] = true;
                        int sum = sumIsland(maps, i, j);
                        tmp.add(sum);

                    }
                }
            }
            Collections.sort(tmp);
            if (tmp.size() == 0) return new int[] {-1};

            answer = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                answer[i] = tmp.get(i);
            }



            return answer;
        }
    }