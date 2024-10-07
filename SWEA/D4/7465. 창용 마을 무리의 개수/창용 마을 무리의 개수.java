import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
     
    /*
     * N명의 사람
     * 1번 부터 N번까지 번호가 붙어있음
     * 두 사람은 서로를 알고 있는 관계일수도 아닐수도 있다
     * 직접적으로 혹은 거쳐서 알수 있는 관계면 하나의 무리
     * 몇 개의 무리가 존재하는 지
     * 1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2
     */
     
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
        parents[findSet(v)] = findSet(u);
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        TC = Integer.parseInt(st.nextToken());
         
        for(int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
             
            for(int i = 1; i <= N; i++) {
                makeSet(i);
            }
             
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
             
            int cnt = 0;
            int[] res = new int[N+1];
            for (int i = 1; i <= N; i++) {
                // 갱신
                res[findSet(i)]++;
            }
            for (int i = 1; i <= N; i++) {
                if (res[i] > 0) cnt++;
            }
             
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
}