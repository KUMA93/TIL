import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, L, maxTaste;
    static boolean[] isSelected;
    static int[][] ingr;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 개수
            L = Integer.parseInt(st.nextToken()); // 칼로리 제한
            ingr = new int[N][2];
            isSelected = new boolean[N];
            maxTaste = 0;
             
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int T = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                ingr[i][0] = T;
                ingr[i][1] = K;
            }
             
            subset(0, 0, 0);
            System.out.printf("#%d %d\n", t, maxTaste);
        } 
    }
     
    private static void subset(int count, int taste, int calo) {
        if(calo > L) return;
        if(count == N) {
            maxTaste = Math.max(maxTaste, taste);
            return;
        }
        isSelected[count] = true;
        subset(count+1, taste + ingr[count][0], calo + ingr[count][1]);
        isSelected[count] = false;
        subset(count+1, taste, calo);
    }
     
     
}