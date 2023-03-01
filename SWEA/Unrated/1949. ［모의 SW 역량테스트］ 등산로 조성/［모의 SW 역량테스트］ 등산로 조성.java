import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    static int TC, N, K, res;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<pos> highest;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
 
    static class pos {
        int x;
        int y;
        int c;
        int d;
 
        public pos(int x, int y, int c, int d) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.d = d;
        }
    }
 
    /*
    가장 높은 봉우리에서 시작 -> 점점 낮아지게 조성
    한 곳을 정해서 K까지 깎기 가능
    3 ≤ N ≤ 8
    1 ≤ K ≤ 5
    각 원소는 1이상 20 이하
    가장 높은 봉우리는 최대 5개
    1보다 작게 깎는 것 가능
     */
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        TC = Integer.parseInt(st.nextToken());
 
        for(int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            res = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            highest = new ArrayList<>();
 
            int max = 0;
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) highest.add(new pos(i, j, 1, 1));
 
                }
            }
 
            for (int i = 0; i < highest.size(); i++)
                hikingRoad(highest.get(i));
 
            System.out.print("#" + t + " " + res + "\n");
        }
    }
 
    public static void hikingRoad(pos p) {
        res = Math.max(res, p.d);
        visited[p.x][p.y] = true;
 
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
 
            if (isInMap(nx, ny) && !visited[nx][ny]){
                if(map[nx][ny] < map[p.x][p.y]){
                    hikingRoad(new pos(nx, ny, p.c, p.d+1));
                }
                else if(p.c == 1 && K > (map[nx][ny] - map[p.x][p.y])){
                    int save = map[nx][ny];
                    map[nx][ny] = map[p.x][p.y]-1;
                    hikingRoad(new pos(nx, ny, p.c-1, p.d+1));
                    map[nx][ny] = save;
                }
            }
        }
        visited[p.x][p.y] = false;
    }
 
    public static boolean isInMap(int x, int y) {
        if((0 <= x && x < N) && (0 <= y && y < N)) return true;
        else return false;
    }
 
}