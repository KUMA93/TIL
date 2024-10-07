import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parents;

    public static void make() {
        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        make();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a, b);
            }
            else {
                if (find(a) == find(b)) System.out.println("yes");
                else System.out.println("no");
            }
        }

    }
}