import java.util.*;
import java.io.*;
public class Main {
    static int TC, F;
    static HashMap<String, String> parents;
    static HashMap<String, Integer> cnt;
    public static String find(String u) {
        if (parents.get(u) == u) return u;
        parents.put(u, find(parents.get(u)));
        return parents.get(u);
    }

    public static void union(String u, String v) {
        parents.put(u, v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            F = Integer.parseInt(br.readLine());

            parents = new HashMap<>();
            cnt = new HashMap<>();

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String fr1 = st.nextToken();
                String fr2 = st.nextToken();

                if (!parents.containsKey(fr1)) {
                    parents.put(fr1, fr1);
                    cnt.put(fr1, 1);
                }

                if (!parents.containsKey(fr2)) {
                    parents.put(fr2, fr2);
                    cnt.put(fr2, 1);
                }

                String a = find(fr1);
                String b = find(fr2);

                if (a != b) {
                    union(a, b);
                    cnt.put(b, cnt.get(a) + cnt.get(b));
                }

                System.out.println(cnt.get(b));
            }

        }
    }
}