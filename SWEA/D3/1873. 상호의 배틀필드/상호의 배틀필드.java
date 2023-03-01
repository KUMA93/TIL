import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    /*
    . 평지
    * 벽돌
    # 강철
    - 물
    ^ 위쪽 방향 전차
    v 아래쪽 방향 전차
    < 왼쪽 방향 전차
    > 오른쪽 방향 전차
 
    U 전차 방향 위쪽으로 바꾸고 평지면 이동
    D 전차 방향 아래쪽으로 바꾸고 평지면 이동
    L 전차 방향 왼쪽으로 바꾸고 평지면 이동
    R 전차 방향 오른쪽으로 바꾸고 평지면 이동
    S 현재 방향으로 포탄 발사
 
    맵 내에서만 이동 / 방향은 바꾸나?
    포탄 발사 시 // 벽돌 벽 파괴 // 강철 벽 멀쩡 / 맵 밖
     */
    // 2 ≤ H, W ≤ 20 / 0 < N ≤ 100
    static int TC, H, W, N, startX, startY;
    static char startDir;
    static String commands;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
 
    static class tank {
        int x;
        int y;
        int dir;
 
        public tank(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TC = Integer.parseInt(st.nextToken());
 
        for (int t = 1; t <= TC; t++) {
            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
 
            for (int i = 0; i < H; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = tmp.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
                        startX = i;
                        startY = j;
                        startDir = map[i][j];
                    }
                }
            }
            int Dir;
            if(startDir == '^') Dir = 0;
            else if(startDir =='v') Dir = 1;
            else if(startDir =='<') Dir = 2;
            else Dir = 3;
 
            N = Integer.parseInt(br.readLine());
            commands = br.readLine();
 
            cmd(new tank(startX, startY, Dir), commands);
 
 
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
 
            System.out.print(sb);
 
        }
    }
 
    public static void cmd(tank t, String cmds) {
        for (int i = 0; i < N; i++) {
            char c = cmds.charAt(i);
            if (c == 'U'){
                t.dir = 0;
                map[t.x][t.y] = '^';
                if (isInMap(t.x-1, t.y) && map[t.x-1][t.y]=='.') {
                    map[t.x][t.y] = '.';
                    t.x-=1;
                    map[t.x][t.y] = '^';
                }
            }
            else if (c == 'D'){
                t.dir = 1;
                map[t.x][t.y] = 'v';
                if (isInMap(t.x+1, t.y) && map[t.x+1][t.y]=='.') {
                    map[t.x][t.y] = '.';
                    t.x+=1;
                    map[t.x][t.y] = 'v';
                }
            }
            else if (c == 'L'){
                t.dir = 2;
                map[t.x][t.y] = '<';
                if (isInMap(t.x, t.y-1) && map[t.x][t.y-1]=='.') {
                    map[t.x][t.y] = '.';
                    t.y-=1;
                    map[t.x][t.y] = '<';
                }
            }
            else if (c == 'R'){
                t.dir = 3;
                map[t.x][t.y] = '>';
                if (isInMap(t.x, t.y+1) && map[t.x][t.y+1]=='.') {
                    map[t.x][t.y] = '.';
                    t.y+=1;
                    map[t.x][t.y] = '>';
                }
            }
            // 발사
            else shoot(t);
        }
    }
 
    public static void shoot(tank t) {
        int x = t.x;
        int y = t.y;
        int dir = t.dir;
        while(true) {
            if (isInMap(x + dx[dir], y + dy[dir])){
                x += dx[dir];
                y += dy[dir];
 
                if (map[x][y] == '*') {
                    map[x][y] = '.';
                    break;
                } else if (map[x][y] == '#') break;
            }else break;
        }
    }
 
    public static boolean isInMap(int x, int y) {
        if ((0 <= x && x < H) && (0 <= y && y < W)) return true;
        else return false;
    }
 
}