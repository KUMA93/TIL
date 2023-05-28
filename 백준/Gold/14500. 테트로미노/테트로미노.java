import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
        정사각형은 서로 겹치면 안 됨
        도형은 모두 연결되어 있어야 됨
        정사각형의 변끼리 연결, 꼭짓점끼리 연결되어 있는 것은 X
        테트로미노의 종류는 5개
        4방향 회전 모두 고려?
        모양을 그려보면 凸 모양 빼고는 사방탐색 완탐으로 자연스럽게 탐색된다.
        4 ≤ N, M ≤ 500
     */
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum, int cnt) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

            if (cnt == 2) {
                visited[nx][ny] = true;
                dfs(x, y, sum + map[nx][ny], cnt + 1);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, sum + map[nx][ny], cnt + 1);
            visited[nx][ny] = false;
        }
    }
}