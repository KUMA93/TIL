import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static String path = "res/input.txt";
    static int dumping;
    static int N = 100;
    static int[] board = new int[100];
     
     
    private static int dump(int[] board) {
        int MAX = board[0];
        int MIN = board[0];
        int maxIdx = 0;
        int minIdx = 0;
         
        for (int i = 0; i < N; i++) {
            if (board[i]>MAX) {
                MAX = board[i];
                maxIdx = i;
            }
            if (board[i]<MIN) {
                MIN = board[i];
                minIdx = i;
            }
        }
        board[minIdx]+=1;
        board[maxIdx]-=1;
         
//      Arrays.sort(board);
//      
//      board[99]-=1;
//      board[0]+=1;
         
        Arrays.sort(board);
        return board[99]-board[0];
    }
     
    public static void main(String[] args) throws IOException {
//      System.setIn(new FileInputStream(path));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
 
        for(int t = 1; t <= 10; t++) {
             
            dumping = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int index=0;
            while(st.hasMoreTokens()) {
                board[index++] = Integer.parseInt(st.nextToken());
            }
             
            int result = 0;
            for (int i = 0; i < dumping; i++) {
                result = dump(board);
            }
             
            System.out.print("#"+ t + " " + result);
            System.out.println();
        }
    }
}