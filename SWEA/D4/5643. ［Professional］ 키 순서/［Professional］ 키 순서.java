import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int TC, N, M, cnt;
    static ArrayList<Integer>[] adj1, adj2;
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj1 = new ArrayList[N];
            adj2 = new ArrayList[N];
            res = new int[N];

            for (int i = 0; i < N; i++) {
                adj1[i] = new ArrayList<>();
                adj2[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                adj1[start].add(end);
                adj2[end].add(start);
            }

            for (int i = 0; i < N; i++) {
                cnt = 0;
                visited = new boolean[N];
                dfs(i, adj1);
                visited = new boolean[N];
                dfs(i, adj2);
                res[i] = cnt;
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (res[i] == N-1) ans++;
            }

            System.out.printf("#%d %d\n", t, ans);
        }
    }

    public static void dfs(int s, ArrayList<Integer>[] adj) {
        for (int next : adj[s]) {
            if (!visited[next]) {
                visited[next] = true;
                cnt++;
                dfs(next, adj);
            }
        }
    }
}