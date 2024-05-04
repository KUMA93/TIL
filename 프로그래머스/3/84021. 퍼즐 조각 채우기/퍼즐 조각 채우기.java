import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        List<int[][]> puzzle = new ArrayList<>();
        List<int[][]> board = new ArrayList<>();

        // 퍼즐 저장
        visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    int[][] res = getShape(1, table, i, j);
                    puzzle.add(res);
                }
            }
        }

        // 보드 저장
        visited = new boolean[game_board.length][game_board[0].length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    int[][] res = getShape(0, game_board, i, j);
                    board.add(res);
                }
            }
        }

        // 음수 좌표 양수로 바꿔서 맵 형태로 저장


        // 확인용
//        System.out.println("======== board =========");
//        for (int[][] x : board) {
//             for (int[] y : x) {
//                 for (int z : y) {
//                     System.out.printf("%d ", z);
//                 }
//                 System.out.println();
//             }
//            System.out.println();
//        }
//
//        System.out.println("======== puzzle =========");
//        for (int[][] x : puzzle) {
//            for (int[] y : x) {
//                for (int z : y) {
//                    System.out.printf("%d ", z);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        // 보드에 퍼즐 넣어보기
        boolean[] used = new boolean[puzzle.size()];

        for (int[][] b : board){
            boolean filled = false;
            for (int i = 0; i < puzzle.size(); i++) {
                if(filled) break;
                if(used[i]) continue;

                int[][] p = puzzle.get(i);
                if(isSame(p, b)) {
                    used[i] = true;

                    int sum = 0;

                    for (int[] x : p) {
                        for (int y : x) {
                            if (y == 1) sum += y;
                        }
                    }

                    answer += sum;
                    filled = true;

                }
            }
        }

        return answer;
    }

    // 모양을 파악하는 메서드 / mode: 0 - board, 1 - table
    public static int[][] getShape(int mode, int[][] map, int sx, int sy) {
        Deque<Integer[]> dq = new ArrayDeque<>();
        Deque<Integer[]> res = new ArrayDeque<>();

        dq.offer(new Integer[]{sx, sy});
        visited[sx][sy] = true;
        res.offer(new Integer[]{0, 0});

        while(!dq.isEmpty()) {
            Integer[] now = dq.pollFirst();

            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isInMap(nx, ny, map) || visited[nx][ny] || map[nx][ny] != mode) continue;

                dq.offer(new Integer[]{nx, ny});
                res.offer(new Integer[]{nx - sx, ny - sy});

                visited[nx][ny] = true;

            }
        }

        return transform(res);
    }

    // 음수 좌표 양수로 변환 후 2차원 맵으로 변환
    public static int[][] transform(Deque<Integer[]> origin) {
        for (Integer[] x : origin) {
            int a = x[0];
            int b = x[1];
            if (x[0] < 0 && x[1] < 0) {
                for (Integer[] y : origin) {
                    y[0] -= a;
                    y[1] -= b;
                }
            }else if (x[0] < 0) {
                for (Integer[] y : origin) {
                    y[0] -= a;
                }
            }else if (x[1] < 0) {
                for (Integer[] y : origin) {
                    y[1] -= b;
                }
            }
        }

        int maxX = 0, maxY = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (Integer[] x : origin) {
            maxX = Math.max(maxX, x[0]);
            maxY = Math.max(maxY, x[1]);
            minX = Math.min(minX, x[0]);
            minY = Math.min(minY, x[1]);
        }

        int[][] map = new int[maxX - minX + 1][maxY - minY + 1];;

        for (Integer[] x : origin) {
            map[x[0] - minX][x[1] - minY] = 1;
        }
        return map;

    }

    // 조각이 일치하는 지 체크하는 메서드
    public static boolean isSame(int[][] piece, int[][] target) {

        int num = 4;

        boolean ret = false;

        while(num > 0) {
            int[][] rotatedMap = rotate(piece);

            num--;

            piece = rotatedMap;
            if (rotatedMap.length != target.length) continue;

            if (isEquals(rotatedMap, target)) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    // 조각을 90도 회전시키는 메서드
    public static int[][] rotate(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = map[i][j];
            }
        }

        return rotated;
    }

    // 배열의 요소 비교 메서드
    public static boolean isEquals(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }

        return true;
    }

    public static boolean isInMap(int x, int y, int[][] map) {
        return (0 <= x && x < map.length) && (0 <= y && y < map[0].length);
    }
}