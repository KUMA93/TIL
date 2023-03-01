import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int TC, N, M;
    static int[] parents;
     
    public static void makeSet(int v) {
        parents[v] = v;
    }
     
    public static int findSet(int v) {
        if(v == parents[v]) return v;
        return parents[v] = findSet(parents[v]);
    }
     
    public static void union(int u, int v) {
        parents[findSet(u)] = findSet(v);
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        TC = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
             
            for(int i = 1; i <= N; i++) {
                makeSet(i);
            }
             
            System.out.printf("#%d ", t);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                if (cmd == 0) {
                    union(a, b);
                }else {
                    if(findSet(a) == findSet(b)) System.out.print(1);
                    else System.out.print(0);
                }
                 
            }
            System.out.println();
        }
         
    }
}