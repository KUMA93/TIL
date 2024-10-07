import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    /*
     * 구슬 N번 발사
     * W * H 벽돌(원소는 1 ~ 9)
     * 벽돌의 숫자 - 1 만큼 십자로 제거
     * 1 ≤ N ≤ 4
     * 2 ≤ W ≤ 12
     * 2 ≤ H ≤ 15
     */
    static int TC, N, W, H, min;
    static int[] selected;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            map = new int[H][W];
            selected = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(0);
            System.out.printf("#%d %d\n", t, min);
        }
    }

    public static void permutation(int cnt) {
        if(cnt == N) {
            int[][] cpyMap = copyMap(map);
            for (int i = 0; i < N; i++) {
                breakBrick(selected[i], cpyMap);
                // 남은 벽돌 아래로 내리기
                drop(cpyMap);
            }

            // 남은 벽돌 세기
            int num = 0;
            for (int i = 0; i < H; i++){
                for (int j = 0; j < W; j++) {
                    if(cpyMap[i][j] > 0) num++;
                }
            }
            min = Math.min(min, num);
            return;
        }
        for(int i = 0; i < W; i++) {
            selected[cnt] = i;
            // 중복을 허용해서 순열을 구한다
            permutation(cnt + 1);
        }
    }
    
    private static Stack<Integer> stack = new Stack<>();
    
    private static void drop(int[][] m) {
    	// 스택 활용 코드
    	for (int c = 0; c < W; c++) {
    		for (int r = 0; r < H; r++) {
    			if(m[r][c] > 0) {
    				stack.push(m[r][c]);
    				m[r][c] = 0;
    			}
    		}
    		int r = H-1;
    		while(!stack.isEmpty()) {
    			m[r--][c] = stack.pop();
    		}
    	}

    	// 내코드
//        for (int i = H-2; i >= 0; i--){
//            for (int j = 0; j < W; j++) {
//                if(m[i][j] > 0 && m[i+1][j] == 0){
//                    int k = 1;
//                    while(i+k < H) {
//                        if(m[i+k][j] == 0) k++;
//                        else break;
//                    }
//
//                    m[i+k-1][j] = m[i][j];
//                    m[i][j] = 0;
//                }
//            }
//        }
    }

    public static void breakBrick(int y, int[][] m) {

        for (int i = 0; i < H; i++) {
            if (m[i][y] != 0) {
                int value = m[i][y];
                m[i][y] = 0;
                if(value > 1) {
                    chain(value, i, y, m);
                }
                break;
            }
        }
    }

    public static void chain(int value, int x, int y, int[][] m) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;

            for (int v = 1; v < value; v++) {
                nx += dx[i];
                ny += dy[i];
                if(0 > nx || nx >= H || 0 > ny || ny >= W) break;
                int newVal = m[nx][ny];
                m[nx][ny] = 0;
                if(newVal > 1) {
                    chain(newVal, nx, ny, m);
                }
            }
        }
    }

    public static int[][] copyMap (int[][] orig){
        int[][] cpy = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                cpy[i][j] = orig[i][j];
            }
        }
        return cpy;
    }
}