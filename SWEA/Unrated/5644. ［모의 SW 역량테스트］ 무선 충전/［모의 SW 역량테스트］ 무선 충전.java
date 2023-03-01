import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    // 총 이동 시간 : M
    // BC의 정보 개수 : A
    static int TC, M, A;
    static int[] moveA, moveB;
    static BC[] chargers;
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
 
    static class Pos {
        int x;
        int y;
 
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static class BC {
        int x;
        int y;
        int c;
        int p;
 
        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
 
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        TC = Integer.parseInt(st.nextToken());
 
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M+1];
            moveB = new int[M+1];
            chargers = new BC[A];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers[i] = new BC(x, y, c, p);
            }
 
            System.out.print("#" + t + " " +simulation(new Pos(1, 1), new Pos(10, 10)) + "\n");
        }
    }
 
    public static int getCharge(int x, int y, BC bc) {
        if (Math.abs(x - bc.x) + Math.abs(y - bc.y) <= bc.c) return bc.p;
        else return 0;
    }
 
    public static int simulation(Pos a, Pos b) {
        int result = 0;
        for (int i = 0; i <= M; i++) {
            a.x += dx[moveA[i]];
            a.y += dy[moveA[i]];
            b.x += dx[moveB[i]];
            b.y += dy[moveB[i]];
            int max = 0;
 
            for (int j = 0; j < A; j++) {
                for (int k = 0; k < A; k++) {
                    int sum = 0;
                    int aValue = getCharge(a.x, a.y, chargers[j]);
                    int bValue = getCharge(b.x, b.y, chargers[k]);
 
                    if(j != k)
                        sum = aValue + bValue;
                    else
                        sum = Math.max(aValue, bValue);
 
                    max = Math.max(max, sum);
                }
            }
 
            result += max;
        }
        return result;
    }
}