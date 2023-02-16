import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, minValue;
    static int[][] board, command;
    static int[] perRes;
    static boolean[] isSelected;

    // 배열 결과값: 각 행의 총합 중 최소값
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minValue = Integer.MAX_VALUE;
        board = new int[N][M];
        command = new int[K][3];
        perRes = new int[K];
        isSelected = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                command[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(0);

        System.out.println(minValue);
    }

    // (r, c) 중심으로 s 범위의 사각형 시계 방향 회전
    // (r-s, c-s) ~ (r-s, c+s) / (r-s, c+s) ~ (r+s, c+s) / (r+s, c+s) ~ (r+s, c-s) / (r+s, c-s) ~ (r-s, c-s)
    // s가 0인 경우 중심 하나만 고려대상이라 안 돌아도 됨
    public static void turn(int[] perRes, int[][] tmpBoard) {
        for(int k = 0; k < K; k++) {
            int R = command[perRes[k]][0] - 1;
            int C = command[perRes[k]][1] - 1;
            int S = command[perRes[k]][2];

            for (int s = 1; s < S + 1; s++) {
                int cs = C + s;
                int sc = C - s;
                int rs = R + s;
                int sr = R - s;

                int upTmp = tmpBoard[sr][cs];
                for (int y = cs; y > sc; y--) {
                    tmpBoard[sr][y] = tmpBoard[sr][y - 1];
                }

                int rightTmp = tmpBoard[rs][cs];
                for (int x = rs; x > sr; x--) {
                    tmpBoard[x][cs] = tmpBoard[x - 1][cs];
                }
                tmpBoard[sr + 1][cs] = upTmp;

                int downTmp = tmpBoard[R + s][C - s];
                for (int y = sc; y < cs; y++) {
                    tmpBoard[rs][y] = tmpBoard[rs][y + 1];
                }
                tmpBoard[rs][cs - 1] = rightTmp;

                for (int x = sr; x < rs; x++) {
                    tmpBoard[x][sc] = tmpBoard[x + 1][sc];
                }
                tmpBoard[rs - 1][sc] = downTmp;
            }
        }
        // 행렬 합 계산
        for (int i = 0; i < N; i++) {
            int tmpSum = 0;
            for (int j = 0; j < M; j++) {
                tmpSum += tmpBoard[i][j];
            }
            minValue = Math.min(minValue, tmpSum);
        }

    }

    // 명령어 순서 정하는 순열 제조기
    public static void permutation(int cnt) {
        if(cnt == K) {
            // 원본 보드를 훼손하면 다른 경우에 문제가 생기기 때문에 보드의 원소만 tmp에 그대로 복사
            int[][] tmpBoard = copyBoard();
            turn(perRes, tmpBoard);
            return;
        }
        for(int i=0; i<K; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            perRes[cnt] = i;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    // 보드를 그대로 복사
    public static int[][] copyBoard() {
        int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        return tmp;
    }
}