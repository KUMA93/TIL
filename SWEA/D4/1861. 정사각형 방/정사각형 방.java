import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, maxDist, maxValue;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
     
    static class Pos {
        int x;
        int y;
         
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    } 
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int tc = Integer.parseInt(st.nextToken());
         
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            maxDist = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            } 
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(new Pos(i, j));
                }
            }
            System.out.printf("#%d %d %d\n", t, maxValue, maxDist);
 
        }
    }
 
    private static void bfs(Pos p) {
        Queue<Pos> queue = new LinkedList<Pos>();
        queue.offer(p);
        visited = new boolean[N][N]; 
        visited[p.x][p.y] = true;
        int cnt = 1;
         
        while (!queue.isEmpty()) {
            Pos curP = queue.poll();
            int x = curP.x;
            int y = curP.y;
             
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                 
                if((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                        if(!visited[nx][ny] && (board[nx][ny] - board[x][y])== 1) {
                            cnt++;
                            visited[nx][ny] = true;
                            queue.offer(new Pos(nx, ny));
                        }
                } 
            }
        }
         
        if(cnt > maxDist) {
            maxDist = cnt;
            maxValue = board[p.x][p.y];
        }
         
        if(cnt == maxDist) {
            if(board[p.x][p.y] < maxValue) {
                maxValue = board[p.x][p.y];
            }
        }
    }
}