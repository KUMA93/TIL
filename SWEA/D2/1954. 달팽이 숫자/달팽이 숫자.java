import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int N;
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int phase;
    static int num;
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
        	StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            num = 1;
            phase = 0;
            max = N*N;
             
            System.out.print("#"+i+"\n");
            snail(0, 0);
            for( int[] bd : board) {
                for( int element : bd) {
                    sb.append(element + " ");
                }
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
     
    private static void snail(int x, int y) {
        board[x][y] = num;
        if (num==max) {
            return;
        }
        num++;
         
        int xx = x + dx[phase];
        int yy = y + dy[phase];
         
        if(isValid(xx, yy)) {   
                snail(xx, yy);
        }else {
            if((phase+1)%4==0) {
                phase = 0;
            }else {
                phase++;
            }
            int fx = x + dx[phase];
            int fy = y + dy[phase];
            snail (fx, fy);
                 
        }
    }
     
    private static boolean isValid(int x, int y) {      
        if ((0<=x && x<N) && (0<=y && y<N) && board[x][y]==0) {
            return true;
        }else {
            return false;
        }
    }
}