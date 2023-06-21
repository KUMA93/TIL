import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] parents;

    public static void make() {
        parents = new int[N+1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int find(int u) {
        if (parents[u] == u) return u;
        return parents[u] = find(parents[u]);
    }

    public static void union(int u, int v) {
        parents[find(u)] = find(v);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        make();

        // 인접 정보
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int target = Integer.parseInt(st.nextToken());
                if (target == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 경로 확인
        st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int now = -1;

        for (int i = 0; i < M; i++) {
            int root = Integer.parseInt(st.nextToken());
            if (now == -1) now = find(root);
            else if (now != find(root)) flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }
}