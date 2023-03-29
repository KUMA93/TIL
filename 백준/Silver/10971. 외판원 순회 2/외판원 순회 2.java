import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean visited[];
    static int res=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i,i,0,0);
            visited[i] = false;
        }

        System.out.println(res);
    }

    public static void DFS(int start, int cur, int sum, int cnt) {
        if(cnt == N-1) {
            if(map[cur][start]!=0) {
                sum += map[cur][start];
                res = Math.min(res, sum);
            }
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i] == false && map[cur][i] != 0) {
                visited[i] = true;
                DFS(start, i, sum + map[cur][i],cnt+1);
                visited[i] = false;
            }
        }
    }

}