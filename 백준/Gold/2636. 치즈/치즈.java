import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M, last, cnt, time;
    static int[][] map;
    static boolean[][] visited, air;
    static Set<int[]> melting;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(checkCheese() == 0) {
                System.out.println(time);
                System.out.println(last);
                break;
            }
            last = cnt;

            melting = new HashSet<>();
            visited = new boolean[N][M];
            air = new boolean[N][M];
            checkAir(0, 0);

            // 치즈의 각 부분에 대해서 녹여줄 부분 구하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) meltingCheese(i, j);
                }
            }

            // 치즈 였던 부분을 공기로 만들어 주기
            for (int[] target : melting) {
                int x = target[0];
                int y = target[1];

                map[x][y] = 0;
                air[x][y] = true;
            }
            time++;
        }

    }

    public static int checkCheese() {
        cnt = 0;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    private static void checkAir(int x, int y) {
        air[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInMap(nx, ny) && map[nx][ny] == 0 && !air[nx][ny]){
                checkAir(nx, ny);
            }
        }
    }

    public static void meltingCheese(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isInMap(nx, ny) || visited[nx][ny]) continue;
            // 공기랑 닿아있으면 녹여줄 리스트에 추가
            if(air[nx][ny]) melting.add(new int[]{x, y});
            // 다른 치즈 부분으로 이동
            if(map[nx][ny] == 1) meltingCheese(nx, ny);
        }
    }

    public static boolean isInMap(int x, int y) {
        if((0 <= x && x < N) && (0 <= y && y < M)) return true;
        return false;
    }
}